import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i = 10;
        while (i > 0) {
            // start
            System.out.println("Welcome");
            System.out.println("Enter start to turn on the vending machine");
            String turnON = input.next();
            while (turnON.equals("start")) {
                int[] productsCount = {10, 10, 10, 10, 10, 10, 10, 10, 10};
                double[] changeArray = {10, 10, 10, 10, 10};
                double[] average = {0, 0, 0, 0, 0, 0, 0, 0, 0};
                double netIncome = 0;
                System.out.println("Enter 1 for customer");
                int start = input.nextInt();
                while (start == 1) {
                    // deposit
                    System.out.println("Enter your deposit");
                    double deposit = input.nextDouble();
                    int selection = 0;
                    double sum = 0;
                    double change=0;

                    showMenu();

                    // selection
                    while (selection != 10) {
                        selection = input.nextInt();
                        sum += makeSelection(selection, productsCount);
                        averageOfProducts(selection , average , changeArray , (deposit - sum));
                        System.out.println("Total= " + sum + "EGP");
                    }
                    if ((changeArray[0] + (changeArray[1] * 0.5) + (changeArray[2] * 0.20) + (changeArray[3] * 0.10) + (changeArray[4] * 0.05)) >= (deposit -sum)) {
                        netIncome += sum;
                    }
                    // more money
                    while (deposit < sum) {
                        System.out.println("Enter more money");
                        double money = input.nextDouble();
                        deposit += money;
                    }

                    System.out.println("**************************");
                    System.out.println("Delivering.....");
                    change = deposit - sum;

                    // change
                    while (change > 0) {
                        if ((changeArray[0] + (changeArray[1] * 0.5) + (changeArray[2] * 0.20) + (changeArray[3] * 0.10) + (changeArray[4] * 0.05)) >= change) {
                            System.out.println("**************************");
                            System.out.println("Change= " + change + "EGP");
                            ReturnChange(change, changeArray);
                            change = 0;
                        } else {
                            System.out.println("Out of change");
                            System.out.println("can't deliver");

                        }
                        break;
                    }

                    // start
                    System.out.println("**************************");
                    System.out.println("Welcome");
                    System.out.println("Enter 1 for customer");
                    start = input.nextInt();


                    // 99
                    if (start == 99) {
                        System.out.println("Enter PIN Code");
                        int code = input.nextInt();
                        if (code == 12345) {
                            System.out.println("Total income= " + netIncome + "EGP");
                            System.out.println("Percentage of sold products: " + "\nWater: " + ((average[0] / 10) * 100)
                                    + "\nCoke: " + ((average[1] / 10) * 100) + "\nDiet Coke: " + ((average[2] / 10) * 100)
                                    + "\nIced Tea: " + ((average[3] / 10) * 100) + "\nSwiss Chocolate: " + ((average[4] / 10) * 100)
                                    + "\nCandy: " + ((average[5] / 10) * 100) + "\nChips: " + ((average[6] / 10) * 100)
                                    + "\nBubble Gum: " + ((average[7] / 10) * 100) + "\nTurkish Delight: " + ((average[8] / 10) * 100));
                            break;
                        } else {
                            System.out.println("Access Denied");
                        }
                        break;
                    }
                }
            }
            break;
        }
    }

    public static void showMenu() {
        System.out.println("Enter : \n1. Water 0.75 EGP\n" +
                "2. Coke 1.20 EGP\n" +
                "3. Diet Coke 1.20 EGP\n" +
                "4. Iced Tea 1.00 EGP\n" +
                "5. Swiss Chocolate 1.50 EGP\n" +
                "6. Candy 0.95 EGP\n" +
                "7. Chips 1.10 EGP\n" +
                "8. Bubble Gum 0.50 EGP\n" +
                "9. Turkish Delight 1.20 EGP\n" +
                "10. End of Transaction");
    }

    public static double makeSelection(int selection, int[] productsCount) {
        double sum = 0;
        if (selection <= 10 && selection > 0) {
            switch (selection) {
                case 1:
                    if (productsCount[0] > 0) {
                        sum += 0.75;
                        productsCount[0]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 2:
                    if (productsCount[1] > 0) {
                        sum += 1.20;
                        productsCount[1]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 3:
                    if (productsCount[2] > 0) {
                        sum += 1.20;
                        productsCount[2]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 4:
                    if (productsCount[3] > 0) {
                        sum += 1.0;
                        productsCount[3]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 5:
                    if (productsCount[4] > 0) {
                        sum += 1.50;
                        productsCount[4]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 6:
                    if (productsCount[5] > 0) {
                        sum += 0.95;
                        productsCount[5]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 7:
                    if (productsCount[6] > 0) {
                        sum += 1.10;
                        productsCount[6]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 8:
                    if (productsCount[7] > 0) {
                        sum += 0.50;
                        productsCount[7]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 9:
                    if (productsCount[8] > 0) {
                        sum += 1.20;
                        productsCount[8]--;
                        break;
                    } else {
                        System.out.println(DisplayErrorMessage());
                    }
                    break;
                case 10:
                    break;
            }
        } else {
            System.out.println("Invalid Option");
        }
        return sum;
    }


    public static String DisplayErrorMessage() {
        return "Error Unavailable item";
    }


    public static double ReturnChange(double change, double[] changeArray) {

        change = (change * 100) + 1;
        Math.round(change);

        double rone = change % 100;
        double done = (int) change / 100;
        double r50 = rone % 50;
        double d50 = (int) rone / 50;
        double r20 = r50 % 20;
        double d20 = (int) r50 / 20;
        double r10 = r20 % 10;
        double d10 = (int) r20 / 10;
        double rhalf = r10 % 5;
        double dhalf = (int) r10 / 5;

        while (change > 0) {


            // ones conditions
            if (changeArray[0] - done > 0) {

                System.out.println("1 EGP: " + done);
                changeArray[0] -= done;
            } else {
                if ((changeArray[0] - done) < 0) {
                    System.out.println("1 EGP: " + changeArray[0]);
                    done -= changeArray[0];
                    changeArray[0] = 0;
                } else {
                    break;
                }
            }

            // 0.50 conditions
            if ((changeArray[1] - d50) > 0) {
                if (done > 0 && changeArray[0] == 0) {
                    if ((done * 2) < changeArray[1]) {
                        System.out.println("0.50 EGP: " + (d50 + (done * 2)));
                        done -= (done * 2);
                        changeArray[1] -= (d50 + (done * 2));
                    } else {
                        System.out.println("0.50 EGP: " + changeArray[1]);
                        done = ((done * 2) - changeArray[1]);
                        changeArray[1] = 0;
                    }
                } else {
                    System.out.println("0.50 EGP: " + d50);
                    changeArray[1] -= d50;
                }
            }


            // 0.20 conditions
            if ((changeArray[2] - d20) > 0) {
                if (done > 0 && changeArray[1] == 0) {
                    if (((done * 5)) < changeArray[2]) {
                        System.out.println("0.20 EGP: " + (d20 + (done * 5)));
                        done -= (done * 5);
                        changeArray[2] -= (d20 + (done * 5));
                    } else {
                        System.out.println("0.20 EGP: " + changeArray[2]);
                        done = (((done * 5)) - changeArray[2]);
                        changeArray[2] = 0;
                    }
                } else {
                    System.out.println("0.20 EGP: " + d20);
                    changeArray[2] -= d20;
                }
            }

            // 0.10 conditions
            if ((changeArray[3] - d10) > 0) {
                if (done > 0 && changeArray[2] == 0) {
                    if ((done * 10) < changeArray[3]) {
                        System.out.println("0.10 EGP: " + (d10 + (done * 10)));
                        done -= (done * 10);
                        changeArray[3] -= (d10 + (done * 10));
                    } else {
                        System.out.println("0.10 EGP: " + changeArray[3]);
                        d10 = ((done * 10) - changeArray[3]);
                        changeArray[3] = 0;
                    }
                } else {
                    System.out.println("0.10 EGP: " + d10);
                    changeArray[3] -= d10;
                }

            }

            // 0.05 conditions
            if ((changeArray[4] - dhalf) > 0) {
                if (done > 0 && changeArray[3] == 0) {
                    if ((done * 20) < changeArray[4]) {
                        System.out.println("0.05 EGP: " + (dhalf + (done * 20)));
                        changeArray[4] -= (dhalf + (done * 20));
                    } else {
                        System.out.println("0.05 EGP: " + changeArray[4]);
                        dhalf = ((done * 20) - changeArray[4]);
                        changeArray[4] = 0;
                    }
                } else {
                    System.out.println("0.05 EGP: " + dhalf);
                    changeArray[4] -= dhalf;
                }

            }
            break;
        }
        return 0;
    }


    public static double averageOfProducts(int selection, double[] average, double [] changeArray , double change) {
        while (selection != 10) {
            if ((changeArray[0] + (changeArray[1] * 0.5) + (changeArray[2] * 0.20) + (changeArray[3] * 0.10) + (changeArray[4] * 0.05)) >= change) {
                switch (selection) {
                    case 1:
                        if (average[0] < 10) {
                            average[0]++;
                            return average[0];
                        } else {
                            break;
                        }
                    case 2:
                        if (average[1] < 10) {
                            average[1]++;
                            return average[1];
                        } else {
                            break;
                        }
                    case 3:
                        if (average[2] < 10) {
                            average[2]++;
                            return average[2];
                        } else {
                            break;
                        }
                    case 4:
                        if (average[3] < 10) {
                            average[3]++;
                            return average[3];
                        } else {
                            break;
                        }
                    case 5:
                        if (average[4] < 10) {
                            average[4]++;
                            return average[4];
                        } else {
                            break;
                        }
                    case 6:
                        if (average[5] < 10) {
                            average[5]++;
                            return average[5];
                        } else {
                            break;
                        }
                    case 7:
                        if (average[6] < 10) {
                            average[6]++;
                            return average[6];
                        } else {
                            break;
                        }
                    case 8:
                        if (average[7] < 10) {
                            average[7]++;
                            return average[7];
                        } else {
                            break;
                        }
                    case 9:
                        if (average[8] < 10) {
                            average[8]++;
                            return average[8];
                        } else {
                            break;
                        }
                    case 10:
                        break;
                }
                break;
            }
            break;
        }
        return 0;
    }
}