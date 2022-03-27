package com.fges.tp_solid.reigns;

import java.util.ArrayList;

public class JeuGot extends Jeu {
    private static ArrayList<Question> questions;

    private static void initBanqueQuestions() {
        questions = new ArrayList<>();
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -10);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +10);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -14);
        questions.add(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE, -10);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +10);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -10);
        questions.add(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +10);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -6);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -10);
        questions.add(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +6);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -6);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -6);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +6);
        questions.add(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +20);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -10);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +2);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -6);
        questions.add(question5);
        Question question6 = new Question(
                "Main du roi",
                "Les caisses sont vides...",
                "Augmenter les taxes",
                "Emprunter");
        question6.ajouteEffetGauche(TypeJauge.FINANCE, +20);
        question6.ajouteEffetGauche(TypeJauge.PEUPLE, -10);
        question6.ajouteEffetDroite(TypeJauge.FINANCE, +14);
        question6.ajouteEffetDroite(TypeJauge.PEUPLE, -6);
        questions.add(question6);
        Question question7 = new Question(
                "Prêtre",
                "J'aimerai que l'on nous considère en tant que tel",
                "Construire un monastère",
                "Ecouter sans rien faire");
        question7.ajouteEffetGauche(TypeJauge.CLERGE, +10);
        question7.ajouteEffetGauche(TypeJauge.FINANCE, -10);
        question7.ajouteEffetDroite(TypeJauge.CLERGE, -10);
        questions.add(question7);

    }
    public static void  Winter(Personnage personnage)
    {
        initBanqueQuestions();
            Question question = Question.getQuestionAleatoire(questions,personnage);
            Question.reponseQuestion(question,personnage);
            personnage.AfficheJauges();
        }
    }
