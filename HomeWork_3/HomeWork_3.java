package GeekBrains_Java_One.HomeWork_3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_3 {
    private static final char DOT_HUMAN = 'X', DOT_AI = 'O', DOT_EMPTY = '_';
    private static final int DOTS_TO_WIN = 3;
    private static final int size = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field = new char[size][size];
    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Computer wins!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
    // initField
    private static void initField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }
    // printField
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < size * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < size; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= size * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }
    // humanTurn
    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты (гор и вер) от 1 до " + size + " через пробел>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }
    // aiTurn
    // 1)Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока, и пытаться выиграть сам.
    static void aiTurn() {
        int x = 0, y = 0, countH = 0, countHNull = 0, countV = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;

        for (int i = 0; i < size; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < size; j++) {
                //good vertical move
                if (field[j][i] == DOT_AI) countV++;
                else if (field[j][i] == DOT_EMPTY) countVNull++;
                if ((countV == size - 1) && (countVNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (field[k][i] == DOT_EMPTY) {
                            field[k][i] = DOT_AI;
                            return;
                        }
                    }
                }
                //good Horizontal move
                if (field[i][j] == DOT_AI) countH++;
                else if (field[i][j] == DOT_EMPTY) countHNull++;
                if ((countH == size - 1) && (countHNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (field[i][k] == DOT_EMPTY) {
                            field[i][k] = DOT_AI;
                            return;
                        }
                    }
                }

            }

            // good diagonal A "\" move
            if (field[i][i] == DOT_AI) countDiagonalA++;
            else if (field[i][i] == DOT_EMPTY) countDANull++;
            if ((countDiagonalA == size - 1) && (countDANull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (field[j][j] == DOT_EMPTY) {
                        field[j][j] = DOT_AI;
                        return;
                    }
                }
            }

            // good diagonal B "/" move
            if (field[i][size - 1 - i] == DOT_AI) countDiagonalB++;
            else if (field[i][size - 1 - i] == DOT_EMPTY)  countDBNull++;
            if ((countDiagonalB == size - 1) && (countDBNull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (field[j][size - 1 - j] == DOT_EMPTY) {
                        field[j][size - 1 - j] = DOT_AI;
                        return;
                    }
                }
            }
        }

        countH = 0;
        countHNull = 0;
        countV = 0;
        countVNull = 0;
        countDiagonalA = 0;
        countDiagonalB = 0;
        countDANull = 0;
        countDBNull = 0;

        // 2. Blocking player
        for (int i = 0; i < size; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < size; j++) {
                //good vertical move
                if (field[j][i] == DOT_HUMAN) countV++;
                else if (field[j][i] == DOT_EMPTY) countVNull++;
                if ((countV == size - 1) && (countVNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (field[k][i] == DOT_EMPTY) {
                            field[k][i] = HomeWork_3.DOT_AI;
                            return;
                        }
                    }
                }
                //good Horizontal move
                if (field[i][j] == DOT_HUMAN) countH++;
                else if (field[i][j] == DOT_EMPTY) countHNull++;
                if ((countH == size - 1) && (countHNull == 1)) {
                    for (int k = 0; k < size; k++) {
                        if (field[i][k] == DOT_EMPTY) {
                            field[i][k] = DOT_AI;
                            return;
                        }
                    }
                }

            }

            // good diagonal A "\" move
            if (field[i][i] == DOT_HUMAN) countDiagonalA++;
            else if (field[i][i] == DOT_EMPTY) countDANull++;
            if ((countDiagonalA == size - 1) && (countDANull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (field[j][j] == DOT_EMPTY) {
                        field[j][j] = DOT_AI;
                        return;
                    }
                }
            }

            // good diagonal B "/" move
            if (field[i][size - 1 - i] == DOT_HUMAN) countDiagonalB++;
            else if (field[i][size - 1 - i] == DOT_EMPTY)  countDBNull++;
            if ((countDiagonalB == size - 1) && (countDBNull == 1)) {
                for (int j = 0; j < size; j++) {
                    if (field[j][size - 1 - j] == DOT_EMPTY) {
                        field[j][size - 1 - j] = DOT_AI;
                        return;
                    }
                }
            }
        }

        // 3. Taking center of map
        if (!(size % 2 == 0)) {
            int center = (((size + 1) / 2) - 1);
            if (field[center][center] == DOT_EMPTY) {
                field[center][center] = DOT_AI;
                return;
            }
        }

        // 4. Taking diagonal points of map
        if (field[0][0] == DOT_EMPTY) { field[0][0] = DOT_AI; return; }
        if (field[0][field.length - 1] == DOT_EMPTY) { field[0][field.length - 1] = DOT_AI; return; }
        if (field[field.length - 1][0] == DOT_EMPTY) { field[field.length - 1][0] = DOT_AI; return; }
        if (field[field.length - 1][field.length - 1] == DOT_EMPTY) { field[field.length - 1][field.length - 1] = DOT_AI; return; }

        // 5. random move
        do {
            x = RANDOM.nextInt(size);
            y = RANDOM.nextInt(size);
        } while (!isCellValid(x, y));
        field[y][x] = DOT_AI;
        System.out.println("AI X: " + (x + 1) + " Y: " + (y + 1));
    }
    // checkWin
    // 1) Переделать проверку победы, чтобы она не была реализована просто набором условий.
    // 2) Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества символов 4.
    private static boolean checkWin(char symb) {
        int winToD1 = 0,  winToD2 = 0;

        for (int i = 0; i < size; i++) {
            int winToCol = 0, winToRow = 0;

            for (int j = 0; j < size; j++) {
                if (field[i][j] == symb) winToRow++;
                if (field[j][i] == symb) winToCol++;
            }
            // условия победы
            if (winToRow == DOTS_TO_WIN || winToCol == DOTS_TO_WIN) return true;
            // диоганали
            if (field[i][i] == symb) winToD1++;
            if (field[i][field[i].length-i-1] == symb) winToD2++;
        }
        if (winToD1 == DOTS_TO_WIN || winToD2 == DOTS_TO_WIN) return  true;
        return false;
    }
    // checkDraw
    private static boolean isDraw() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }
    // isCellEmpty
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] != DOT_EMPTY;
    }
    // isCellValid
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        if (field[y][x] == DOT_EMPTY) return true;
        return false;
    }
}
