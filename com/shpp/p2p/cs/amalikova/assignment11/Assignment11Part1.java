package com.shpp.p2p.cs.amalikova.assignment11;

import java.util.*;

public class Assignment11Part1 {
    private static final HashMap<String, Integer> signRatings = new HashMap<>
            (Map.of("^", 3, "*", 2, "/", 2, "+", 1, "-", 1));
    private static final HashMap<String, ArrayList<String>> formulas = new HashMap<>();

    /*
     * Runs the calculator and handles possible errors.
     */
    public static void main(String[] args) {
        try {
            calculator(args);
        } catch (Exception e) {
            System.out.println("There are some problems with your expression");
        }
    }

    /*
     * Brings the formula and variables into the proper form and starts the process of parsing the formula.
     */
    public static void calculator(String[] args) {
        String formula = args[0].replaceAll(" ", "");
        formula = formula.replaceAll(",", ".");
        HashMap<String, Double> variables = variablesParsing(args);
        formulaParsingCalculation(formula, variables);
    }

    /*
     * If the formula has already been used, we take it;
     * if not, we parse the formula. After that, we start the calculation process.
     */
    public static void formulaParsingCalculation(String formula, HashMap<String, Double> variables) {
        ArrayList<String> currentFormula = null;
//        for (Map.Entry<String, ArrayList<String>> entry : formulas.entrySet()) {
//            if (entry.getKey().equals(formula)) {
//                currentFormula = (ArrayList<String>) entry.getValue().clone();
//                break;
//            }
//        }
        if (currentFormula == null) {
            currentFormula = formulaParsing(formula);
        }
        calculate(currentFormula, variables);
    }

    /*
     * Variables parsing
     */
    public static HashMap<String, Double> variablesParsing(String[] args) {
        HashMap<String, Double> variables = new HashMap<>();
        for (int i = 1; i < args.length; i++) {
            String var = args[i].replaceAll(" ", "");
            var = var.replaceAll(",", ".");
            if (var.equals("")) {
                continue;
            }
            String letter = var.substring(0, var.indexOf("="));
            double number = Double.parseDouble(var.substring(var.indexOf("=") + 1));
            variables.put(letter, number);
        }
        return variables;
    }

    /*
     * Formula parsing using Polish notation.
     */
    public static ArrayList<String> formulaParsing(String formula) {
        String[] elements = formula.split("(?=[-()+*/^])");
        ArrayList<String> separatedList = getSeparatedList(elements);
        ArrayList<String> polandList = polandNotation(separatedList);
        formulas.put(formula, (ArrayList<String>) polandList.clone());
        return polandList;
    }

    /*
     * Splitting the formula into a more usable array of data.
     */
    public static ArrayList<String> getSeparatedList(String[] elements) {
        ArrayList<String> separatedList = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].contains("+") || elements[i].contains("-") || elements[i].contains("/") || elements[i].contains("*") || elements[i].contains("^") || elements[i].contains("(")) {
                if ((elements[i].matches("^-?[0-9]+(\\.[0-9]+)?") || elements[i].matches("^-?[a-zA-Z]+$")) && ((i == 0) || (separatedList.get(separatedList.size() - 1).matches("[-+*/^]")))) {
                    separatedList.add(elements[i]);
                } else {
                    separatedList.add(elements[i].substring(0, 1));
                    String separated = elements[i].substring(1);
                    if (!separated.equals("")) {
                        separatedList.add(separated);
                    }
                }
            } else {
                separatedList.add(elements[i]);
            }
        }
        return separatedList;
    }

    /*
     * Using Polish notation for calculation.
     */
    public static ArrayList<String> polandNotation(ArrayList<String> separatedList) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < separatedList.size(); i++) {
            if (separatedList.get(i).matches(("^-?[a-zA-Z]+$")) || separatedList.get(i).matches(("^-?[0-9]+(\\.[0-9]+)?"))) {
                arrayList.add(separatedList.get(i));
            }
            if (separatedList.get(i).matches("[(]")) {
                queue.add(separatedList.get(i));
            }
            if (separatedList.get(i).matches("[)]")) {
                do {
                    arrayList.add(queue.pollLast());
                } while (!(queue.getLast().equals("(")));
                queue.pollLast();
            }
            if (separatedList.get(i).matches("[-+*/^]")) {
                if ((!queue.isEmpty()) && (!queue.getLast().equals("(")) && (!queue.getLast().equals(")")) && (signRatings.get(separatedList.get(i)) < signRatings.get(queue.getLast()))) {
                    do {
                        arrayList.add(queue.pollLast());
                    } while ((!(queue.isEmpty())) && ((signRatings.get(separatedList.get(i))) <= signRatings.get(queue.getLast())));
                }
                if ((!queue.isEmpty()) && (!queue.getLast().equals("(")) && (!queue.getLast().equals(")")) && (Objects.equals(signRatings.get(separatedList.get(i)), signRatings.get(queue.getLast())))) {
                    arrayList.add(queue.pollLast());
                }
                queue.add(separatedList.get(i));
            }
        }
        while (!queue.isEmpty()) {
            arrayList.add(queue.pollLast());
        }
        return arrayList;
    }

    /*
     * Calculation and output of the final value.
     */
    public static void calculate(ArrayList<String> formula, HashMap<String, Double> variables) {
        changeVarNum(formula, variables);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < formula.size(); i++) {
            if (formula.get(i).matches("^-?[0-9]+(\\.[0-9]+)?")) {
                result.add(formula.get(i));
            } else {
                if (result.size() == 1 && formula.get(i).equals("-")) {
                    String res = "-" + result.get(0);
                    result.set(0, res);
                } else {
                    double one = Double.parseDouble(result.get(result.size() - 1));
                    double two = Double.parseDouble(result.get(result.size() - 2));
                    result.remove(result.size() - 1);
                    result.remove(result.size() - 1);
                    switch (formula.get(i)) {
                        case "+" -> result.add(String.valueOf(one + two));
                        case "-" -> result.add(String.valueOf(two - one));
                        case "*" -> result.add(String.valueOf(one * two));
                        case "/" -> result.add(String.valueOf(two / one));
                        case "^" -> result.add(String.valueOf(Math.pow(two, one)));
                    }
                }
            }
        }
        System.out.println(result.get(0));
    }

    /*
     * Replacing literal values of variables from numeric values.
     */
    public static void changeVarNum(ArrayList<String> formula, HashMap<String, Double> variables) {
        for (Map.Entry<String, Double> entry : variables.entrySet()) {
            String letter = entry.getKey();
            String number = entry.getValue().toString();
            for (int i = 0; i < formula.size(); i++) {
                if (formula.get(i).contains(letter)) {
                    String element = formula.get(i).replaceAll(letter, number);
                    if (element.contains("--")) {
                        element = element.replaceAll("-", "");
                    }
                    formula.set(i, element);
                }
            }
        }
    }
}
