import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public QuizQuestion(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctAnswerIndex;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private Scanner scanner;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        for (QuizQuestion question : questions) {
            displayQuestion(question);
            int selectedOption = getUserAnswer();
            checkAnswer(question, selectedOption);
        }
        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("\nQuestion: " + question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    private int getUserAnswer() {
        System.out.print("Enter your choice (1-" + questions.get(currentQuestionIndex).getOptions().size() + "): ");
        return scanner.nextInt();
    }

    private void checkAnswer(QuizQuestion question, int selectedOption) {
        if (question.isCorrect(selectedOption)) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Incorrect Answer!");
        }
    }

    private void displayResult() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your score: " + score + " out of " + questions.size());
    }
}

public class QuizApp {
    public static void main(String[] args) {
        // Creating Quiz Questions with options and correct answers
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("London", "Paris", "Berlin", "Madrid"), 2));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?", Arrays.asList("Mars", "Venus", "Jupiter", "Saturn"), 1));
        // Add more questions similarly...

        // Creating a Quiz instance and starting the quiz
        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
