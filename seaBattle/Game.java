package lesson5.seaBattle;

import java.util.Scanner;

public class Game {

    private Player[] players = new Player[2];
    private Field field;

    Scanner scanner = new Scanner(System.in);


    public void settingPlayers(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            field = new Field();
            String playersName;
            while (true) {

                System.out.print("Enter the name of player " + (i + 1) + ": ");
                playersName = scanner.nextLine();
                if (playersName.length() >= 2) {
                    break;
                }
                if (playersName.length() == 0) {
                    System.out.println("Empty name \n try again");
                } else if (playersName.length() == 1) {
                    System.out.println("Player's name cannot consist of one letter");
                } else {
                    System.out.println("Incorrect input");
                }
            }
            players[i] = new Player(playersName, field);
        }
    }

    public void placingShips(char[][] fieldCopy) {
        settingPlayers(players);
        fieldCopy = field.getField().clone();
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nDear " + players[i].getName() + ", set your ships within the board[10x10]\n");
            for (int j = 0; j < field.getShips().size(); j++) {

                System.out.println("ship " + j + " " + field.getShips().get(j).getDecks());

                if (field.getShips().get(j).getDecks() == 1) {
                    while (true) {
                        int row = 0;
                        int column = 0;
                        System.out.println("Specify coordinates for your " + (j + 1) + " ship with 1 deck");
                        field.repaint();
                        System.out.print("Enter the row[0-9]: ");
                        row = scanner.nextInt();
                        System.out.print("Enter the column[0-9]: ");
                        column = scanner.nextInt();
                        if ((row >= 0 && row <= 9) && (column >= 0 && column <= 9) && fieldCopy[row][column] != field.getShipCell()) {

                            if (row == 9 && column == 9) {
                                if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            } else if (row == 0 && column == 0) {
                                if (fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            } else if (row == 9) {
                                if (column == 0) {
                                    if (fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        break;
                                    }
                                } else if (fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            } else if (column == 9) {
                                if (row == 0) {
                                    if (fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        break;
                                    }
                                } else if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            } else if (row == 0) {
                                if (column == 9) {
                                    if (fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        break;
                                    }
                                } else if (fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            } else if (column == 0) {
                                if (row == 9) {
                                    if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        break;
                                    }
                                } else if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            } else {
                                if (fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            }
                        }



                        if (row < 0 || row > 9 || column < 0 || column > 9) {
                            System.out.println("Coordinates that you have specified go beyond the field");
                        } else if (fieldCopy[row][column] == 'O') {
                            System.out.println("This sell is already occupied");
                        } else if (column == 9) {
                            if(row == 0) {
                                if(fieldCopy[row + 1][column] == field.getShipCell() || fieldCopy[row][column - 1] == field.getShipCell()) {
                                    System.out.println("You cannot place your ship next to the adjacent one");
                                }
                            }
                            else if (fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell() || fieldCopy[row][column - 1] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if(row == 9) {
                            if(column == 0) {
                                if(fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row - 1][column] != field.getShipCell()) {
                                    System.out.println("You cannot place your ship next to the adjacent one");
                                }
                            }
                            else if (fieldCopy[row][column - 1] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row - 1][column] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if (column == 0) {
                            if(row == 9) {
                                if(fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell()) {
                                    System.out.println("You cannot place your ship next to the adjacent one");
                                }
                            }
                            else if (fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if (row == 0) {
                            if(column == 9) {
                                if(fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell()) {
                                    System.out.println("You cannot place your ship next to the adjacent one");
                                }
                            }
                            else if (fieldCopy[row][column - 1] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if (fieldCopy[row][column - 1] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell()) {
                            System.out.println("You cannot place your ship next to the adjacent one");
                        } else {
                            System.out.println("Incorrect input");
                        }
                    }
//                    break;
                    }

                      else if (field.getShips().get(j).getDecks() == 2) {
                      while (true) {
                        int row = 0;
                        int column = 0;
                        int row2 = 0;
                        int column2 = 0;
                        System.out.println("Specify coordinates for your " + (j + 1) + " ship with 2 decks");
                        while(true) {
                            int direction;
                            System.out.println("Do you want your ship to be vertical or horizontal? (1-vertical, 2 horizontal)");
                            direction = scanner.nextInt();
                            if(direction == 1) {
                                field.getShips().get(j).setVertical(true);
                                break;
                            } else if (direction == 2) {
                                field.getShips().get(j).setVertical(false);
                                break;
                            }
                            if(direction <= 0 || direction > 2) {
                                System.out.println("You have entered incorrect direction");
                            } else {
                                System.out.println("Incorrect input");
                            }
                        }
                        System.out.println("Specify coordinates for the 1st deck");
                        field.repaint();
                        System.out.print("Enter the row[0-9]: ");
                        row = scanner.nextInt();
                        System.out.print("Enter the column[0-9]: ");
                        column = scanner.nextInt();
                        if ((row >= 0 && row <= 9) && (column >= 0 && column <= 9) && fieldCopy[row][column] != field.getShipCell()) {
                            if(row == 9 && column == 9) {
                                if(field.getShips().get(j).isVertical() == true) {
                                    if(fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        System.out.println("Specify coordinates for the 2nd deck");
                                        System.out.println("As your ship is vertical, in this case you can only choose row 8");
                                        row2 = row - 1;
                                        column2 = column;
                                        if(fieldCopy[row2][column2 - 1] != field.getShipCell() && fieldCopy[row2 - 1][column] != field.getShipCell()) {
                                            fieldCopy[row2][column2] = field.getShipCell();
                                            field.repaint();
                                            break;
                                        }
                                    }
                                }
                                else {
                                    if(fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        System.out.println("Specify coordinates for the 2nd deck");
                                        System.out.println("As your ship is horizontal, in this case you can only choose column 8");
                                        column2 = column - 1;
                                        row2 = row;
                                        if (fieldCopy[row2 - 1][column2] != field.getShipCell() && fieldCopy[row2][column2 - 1] != field.getShipCell()) {
                                            fieldCopy[row2][column2] = field.getShipCell();
                                            field.repaint();
                                            break;
                                        }
                                    }
                                }
                            }
                            else if (row == 0 && column == 0) {
                                if (field.getShips().get(j).isVertical() == true) {
                                    if (fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell()) {
                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            System.out.println("Specify coordinates for the 2nd deck");
                                            System.out.println("As your ship is vertical, in this case you can only choose row 1");
                                            row2 = row + 1;
                                            column2 = column;
                                            if(fieldCopy[row2][column2 + 1] != field.getShipCell() && fieldCopy[row2 + 1][column] != field.getShipCell()) {
                                                fieldCopy[row2][column2] = field.getShipCell();
                                                field.repaint();
                                                break;
                                            }
                                        }
                                    } else {
                                        if (fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell()) {
                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            System.out.println("Specify coordinates for the 2nd deck");
                                            System.out.println("As your ship is horizontal, in this case you can only choose column 1");
                                            column2 = column + 1;
                                            row2 = row;
                                            if(fieldCopy[row2 + 1][column2] != field.getShipCell() && fieldCopy[row2][column2 + 1] != field.getShipCell()) {
                                                fieldCopy[row2][column2] = field.getShipCell();
                                                field.repaint();
                                                break;
                                            }
                                        }
                                    }
                                }
                            else if (row == 9) {
                                if (column == 0) {
                                    if(field.getShips().get(j).isVertical() == true) {
                                        if (fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell()) {
                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            System.out.println("Specify coordinates for the 2nd deck");
                                            System.out.println("As your ship is vertical, in this case you can only choose row 8");
                                            row2 = row - 1;
                                            column2 = column;
                                            if (fieldCopy[row2][column2 + 1] != field.getShipCell() && fieldCopy[row2 - 1][column2] != field.getShipCell()) {
                                                fieldCopy[row2][column2] = field.getShipCell();
                                                field.repaint();
                                                break;
                                            }
                                        }
                                    }
                                    else {
                                        if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell()) {
                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            System.out.println("Specify coordinates for the 2nd deck");
                                            System.out.println("As your ship is horizontal, in this case you can only choose column 1");
                                            column2 = column + 1;
                                            row2 = row;
                                            if (fieldCopy[row2 - 1][column2] != field.getShipCell() && fieldCopy[row2][column2 + 1] != field.getShipCell()) {
                                                fieldCopy[row2][column2] = field.getShipCell();
                                                field.repaint();
                                                break;
                                            }
                                        }
                                    }
                                }
                                else if (column == 1) {
                                    if(field.getShips().get(j).isVertical() == true) {
                                        if(fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell()) {
                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            System.out.println("Specify coordinates for the 2nd deck");
                                            System.out.println("As your ship is vertical, in this case you can only choose row 8");
                                            row2 = row - 1;
                                            column2 = column;
                                            if(fieldCopy[row2][column2 - 1] != field.getShipCell() && fieldCopy[row2][column2 + 1] != field.getShipCell() && fieldCopy[row2 - 1][column2] != field.getShipCell()) {
                                                fieldCopy[row2][column2] = field.getShipCell();
                                                field.repaint();
                                                break;
                                            }
                                        }
                                    }
                                    else {
                                        if(fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell()
                                                && fieldCopy[row][column + 1] != field.getShipCell()) {
                                                fieldCopy[row][column] = field.getShipCell();
                                                field.repaint();
                                                while(true) {
                                                    System.out.println("Specify coordinates for the 2nd deck");
                                                    System.out.print("Enter the column[" + (column - 1) + "," + (column + 1) +"]: ");
                                                    column2 = scanner.nextInt();
                                                    row2 = row;
                                                    if(column2 == column - 1) {
                                                        if(fieldCopy[row2 - 1][column2] != field.getShipCell()) {
                                                            fieldCopy[row2][column2] = field.getShipCell();
                                                            field.repaint();
                                                            break;
                                                        }
                                                    } else if (column2 == column + 1) {
                                                        if(fieldCopy[row2 - 1][column2] != field.getShipCell() && fieldCopy[row2][column2 + 1] != field.getShipCell()) {
                                                            fieldCopy[row2][column2] = field.getShipCell();
                                                            field.repaint();
                                                            break;
                                                        }
                                                    }
                                                    if(column2 == column) {
                                                        System.out.println("You have already selected these coordinates");
                                                    } else if (column2 != column - 1 && column2 != column + 1) {
                                                        System.out.println("Unavailable column");
                                                    }  else {
                                                        System.out.println("Incorrect input or you cannot place your ship next to the adjacent one");
                                                    }
                                                }
                                                break;
                                         }
                                    }
                                }
                                else if(column == 8) {
                                    if(field.getShips().get(j).isVertical() == true) {
                                        if(fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() &&
                                            fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row - 2][column] != field.getShipCell()) {

                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            System.out.println("Specify coordinates for the 2nd deck");
                                            System.out.println("As your ship is vertical, in this case you can only choose row 8");
                                            row2 = row - 1;
                                            column2 = column;
                                            if(fieldCopy[row2][column2 - 1] != field.getShipCell() && fieldCopy[row2][column2 + 1] != field.getShipCell()) {
                                                fieldCopy[row2][column2] = field.getShipCell();
                                                field.repaint();
                                                break;
                                            }
                                        }
                                    }
                                    else {
                                        if(fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() &&
                                                fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column - 2] != field.getShipCell()) {

                                            fieldCopy[row][column] = field.getShipCell();
                                            field.repaint();
                                            while(true) {
                                                System.out.println("Specify coordinates for the 2nd deck");
                                                System.out.print("Enter the column[" + (column - 1) + "," + (column + 1) + "]: ");
                                                column2 = scanner.nextInt();
                                                row2 = row;
                                                if (column2 == column - 1 || column2 == column + 1) {
                                                    fieldCopy[row2][column2] = field.getShipCell();
                                                    field.repaint();
                                                    break;
                                                }
                                                if (column2 == column) {
                                                    System.out.println("You have already selected these coordinates");
                                                } else if (column2 != column - 1 || column2 != column + 1) {
                                                    System.out.println("Unavailable column");
                                                } else {
                                                    System.out.println("Incorrect input");
                                                }
                                            }
                                           break;
                                        }
                                    }
                                }
                                else {
                                    if(field.getShips().get(j).isVertical() == true) {
                                        if(fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row - 2][column] != field.getShipCell() &&
                                            fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell()) {

                                                 fieldCopy[row][column] = field.getShipCell();
                                                 field.repaint();
                                                 System.out.println("Specify coordinates for the 2nd deck");
                                                 System.out.println("As your ship is vertical, in this case you can only choose row 8");
                                                 row2 = row - 1;
                                                 column2 = column;
                                            if(fieldCopy[row2][column2 - 1] != field.getShipCell() && fieldCopy[row2][column2 + 1] != field.getShipCell()) {
                                                 fieldCopy[row2][column2] = field.getShipCell();
                                                 field.repaint();
                                                 break;
                                            }
                                        }
                                        else {
                                            if(fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell() &&
                                                 fieldCopy[row][column + 1] != field.getShipCell()) {
                                                fieldCopy[row][column] = field.getShipCell();
                                                field.repaint();
                                                while(true) {
                                                    System.out.println("Specify coordinates for the 2nd deck");
                                                    System.out.print("Enter the column[" + (column - 1) + "," + (column + 1) + "]: ");
                                                    column2 = scanner.nextInt();
                                                    row2 = row;
                                                    if ((column2 == column - 1 || column2 == column + 1) && fieldCopy[row2][column2 + 1] != field.getShipCell() && fieldCopy[row2][column2 - 1] != field.getShipCell()) {
                                                        fieldCopy[row2][column2] = field.getShipCell();
                                                        field.repaint();
                                                        break;
                                                    }
                                                    if (column2 == column) {
                                                        System.out.println("You have already selected these coordinates");
                                                    } else if (column2 != column - 1 || column2 != column + 1) {
                                                        System.out.println("Unavailable column");
                                                    } else {
                                                        System.out.println("Incorrect input");
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            else if (column == 9) {
                                if (row == 0) {
                                    if (fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell() &&
                                        fieldCopy[row + 2][column] != field.getShipCell() && fieldCopy[row][column - 2] != field.getShipCell()) {
                                        fieldCopy[row][column] = field.getShipCell();
                                        field.repaint();
                                        break;
                                    }
                                }
                                    else if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column - 1] != field.getShipCell() &&
                                    fieldCopy[row - 2][column] != field.getShipCell() && fieldCopy[row + 2][column] != field.getShipCell() && fieldCopy[row][column - 2] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            }
                            else if (row == 0) {
                               if (fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell() &&
                                   fieldCopy[row][column - 2] != field.getShipCell() && fieldCopy[row][column + 2] != field.getShipCell() && fieldCopy[row + 2][column] != field.getShipCell()) {
                                   fieldCopy[row][column] = field.getShipCell();
                                   field.repaint();
                                   break;
                                }
                            }
                            else if (column == 0) {
                                if (fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() &&
                                        fieldCopy[row - 2][column] != field.getShipCell() && fieldCopy[row + 2][column] != field.getShipCell() && fieldCopy[row][column + 2] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            }
                            else {
                                if (fieldCopy[row][column - 1] != field.getShipCell() && fieldCopy[row][column + 1] != field.getShipCell() && fieldCopy[row - 1][column] != field.getShipCell() && fieldCopy[row + 1][column] != field.getShipCell() &&
                                        fieldCopy[row][column - 2] != field.getShipCell() && fieldCopy[row][column + 2] != field.getShipCell() && fieldCopy[row - 2][column] != field.getShipCell() && fieldCopy[row + 2][column] != field.getShipCell()) {
                                    fieldCopy[row][column] = field.getShipCell();
                                    field.repaint();
                                    break;
                                }
                            }

                        }

                        if (row < 0 || row > 9 || column < 0 || column > 9) {
                            System.out.println("Coordinates that you have specified go beyond the field");
                        }
                        else if (row == 9 && column == 9) {
                            if (fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row][column - 1] == field.getShipCell() ||
                                fieldCopy[row - 2][column] == field.getShipCell() || fieldCopy[row][column - 2] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                                fieldCopy[row][column] = field.getEmptyCell();
                                }
                        }
                        else if(column == 0 && row == 0) {
                            if(fieldCopy[row + 1][column] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row + 2][column] == field.getShipCell() || fieldCopy[row][column + 2] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                                fieldCopy[row][column] = field.getEmptyCell();
                            }
                        }
                        else if (fieldCopy[row][column] == field.getShipCell()) {
                            System.out.println("This sell is already occupied");
                            fieldCopy[row][column] = field.getEmptyCell();
                        }
                        else if (column == 9) {
                            if (fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell() || fieldCopy[row][column - 1] == field.getShipCell() ||
                                    fieldCopy[row - 2][column] == field.getShipCell() || fieldCopy[row + 2][column] == field.getShipCell() || fieldCopy[row][column - 2] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if(row == 9) {
                            if(column == 0) {
                                if(fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row - 1][column] != field.getShipCell() ||
                                    fieldCopy[row][column + 2] == field.getShipCell() || fieldCopy[row - 2][column] != field.getShipCell()) {
                                    System.out.println("You cannot place your ship next to the adjacent one");
                                }
                            }
                                else if (fieldCopy[row][column - 1] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row - 1][column] == field.getShipCell() ||
                                    fieldCopy[row][column - 2] == field.getShipCell() || fieldCopy[row][column + 2] == field.getShipCell() || fieldCopy[row - 2][column] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if (column == 0) {
                            if (fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() ||
                                    fieldCopy[row - 2][column] == field.getShipCell() || fieldCopy[row + 2][column] == field.getShipCell() || fieldCopy[row][column + 2] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if (row == 0) {
                            if (fieldCopy[row][column - 1] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell() ||
                                    fieldCopy[row][column - 2] == field.getShipCell() || fieldCopy[row][column + 2] == field.getShipCell() || fieldCopy[row + 2][column] == field.getShipCell()) {
                                System.out.println("You cannot place your ship next to the adjacent one");
                            }
                        } else if (fieldCopy[row][column - 1] == field.getShipCell() || fieldCopy[row][column + 1] == field.getShipCell() || fieldCopy[row - 1][column] == field.getShipCell() || fieldCopy[row + 1][column] == field.getShipCell() ||
                                fieldCopy[row][column - 2] == field.getShipCell() || fieldCopy[row][column + 2] == field.getShipCell() || fieldCopy[row - 2][column] == field.getShipCell() || fieldCopy[row + 2][column] == field.getShipCell()) {
                            System.out.println("You cannot place your ship next to the adjacent one");
                        } else {
                            System.out.println("Incorrect input");
                        }
                    };
//                        break;
                    }

                      else if (field.getShips().get(j).getDecks() == 3) {
                        System.out.println("Specify coordinates for your " + (j + 1) + " ship with 3 decks");
//                        break;
                    } else {
                        System.out.println("Specify coordinates for your " + (j + 1) + " ship with 4 decks");
//                        break;
                    }
                }
            }
//            System.out.println();
        }
    }
//}






