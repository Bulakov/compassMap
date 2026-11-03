package com.example.demo.utils;

public class QuestionnaireRunner   {
    public String runQuestionnaire(Scanner scan) {
        String[] questions = {
                "Have you written code professionally? (y/n)",
                "Can you read a stack trace? (y/n)",
                "Do you want to deepen architecture/DDD skills? (y/n)",
                "Do you want to ship faster with AI tools? (y/n)",
                "Are you new to programming logic? (y/n)"
        };

        int knowsCode = 0;
        int wantsToLearn = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i] + " ");
            String answer = scan.nextLine().trim().toLowerCase();
            if (i < 2 && answer.equals("y")) knowsCode++;
            if (i >= 2 && answer.equals("y")) wantsToLearn++;
        }

        // 2x2 matrix mapping
        if (knowsCode >= 2 && wantsToLearn >= 2) return "Architect";      // experienced + wants depth
        if (knowsCode >= 2 && wantsToLearn < 2)  return "AI Practitioner"; // experienced + wants speed
        if (knowsCode < 2 && wantsToLearn >= 2)  return "Beginner";        // new + wants foundations
        return "Non-Developer";                                             // new + needs literacy only
    }
}
