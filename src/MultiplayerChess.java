
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * File Name: MultiplayerChess 
 * Programmer: Sherwin Varkiani 
 * Date: 6/12/2017
 * Description: This program is a 2-player chess game
 */
public class MultiplayerChess extends javax.swing.JFrame {

    ImageIcon Icon16 = new ImageIcon("Icon16.png");
    ImageIcon Icon15 = new ImageIcon("Icon15.png");
    ImageIcon Icon14 = new ImageIcon("Icon14.png");
    ImageIcon Icon13 = new ImageIcon("Icon13.png");
    ImageIcon Icon24 = new ImageIcon("Icon24.png");
    ImageIcon Icon23 = new ImageIcon("Icon23.png");
    ImageIcon Icon22 = new ImageIcon("Icon22.png");
    ImageIcon Icon21 = new ImageIcon("Icon21.png");
    ImageIcon Icon12 = new ImageIcon("Icon12.png");
    ImageIcon Icon11 = new ImageIcon("Icon11.png");
    ImageIcon Icon10 = new ImageIcon("Icon10.png");
    ImageIcon Icon9 = new ImageIcon("Icon9.png");
    ImageIcon Icon4 = new ImageIcon("Icon4.png");
    ImageIcon Icon3 = new ImageIcon("Icon3.png");
    ImageIcon Icon2 = new ImageIcon("Icon2.png");
    ImageIcon Icon1 = new ImageIcon("Icon1.png");
    ImageIcon Icon20 = new ImageIcon("Icon20.png");
    ImageIcon Icon19 = new ImageIcon("Icon19.png");
    ImageIcon Icon18 = new ImageIcon("Icon18.png");
    ImageIcon Icon17 = new ImageIcon("Icon17.png");
    ImageIcon Icon8 = new ImageIcon("Icon8.png");
    ImageIcon Icon7 = new ImageIcon("Icon7.png");
    ImageIcon Icon6 = new ImageIcon("Icon6.png");
    ImageIcon Icon5 = new ImageIcon("Icon5.png");
    ImageIcon white = new ImageIcon("whitesquare.png");
    ImageIcon black = new ImageIcon("blackSquare.jpg");
    boolean firstClick = false;
    int xPos, yPos, newXPos, newYPos;
    int[][] chessBoard = new int[8][8];
    String location1, location2, pieceName, pieceColour;
    int locationSum, newLocationSum;
    int whiteKingMoveCounter = 0;
    int blackKingMoveCounter = 0;
    boolean whiteMove = true;
    boolean postMoveCheckTest = false;
    int whiteCheckCounter = 0;
    int blackCheckCounter = 0;
    boolean isCheck = false;
    int checkXPos = 0;
    int checkYPos = 0;
    int checkPiece = 0;
    boolean bishopTestCheck = false;
    boolean rookTestCheck = false;
    boolean trueCheck = false;
    boolean kingTestCheck = false;
    long start = System.currentTimeMillis(); //stores the final time
    int whiteMoveCounter = 0;
    int blackMoveCounter = 0;

    JButton[][] buttons = new JButton[8][8]; //create an array to store the buttons for manipulation same format as the chessboard
    ClickListener buttonClickListener; //create a listener which all buttons will use
    String imagePath = Paths.get("").toAbsolutePath().toString();

    /**
     * Creates new form MultiplayerChess
     */
    public MultiplayerChess() {
        initComponents();

        //store the references to the new button objects into the array for quick reference
        buttons[0][0] = Tile1;
        buttons[0][1] = Tile2;
        buttons[0][2] = Tile3;
        buttons[0][3] = Tile4;
        buttons[0][4] = Tile5;
        buttons[0][5] = Tile6;
        buttons[0][6] = Tile7;
        buttons[0][7] = Tile8;

        buttons[1][0] = Tile9;
        buttons[1][1] = Tile10;
        buttons[1][2] = Tile11;
        buttons[1][3] = Tile12;
        buttons[1][4] = Tile13;
        buttons[1][5] = Tile14;
        buttons[1][6] = Tile15;
        buttons[1][7] = Tile16;

        buttons[2][0] = Tile17;
        buttons[2][1] = Tile18;
        buttons[2][2] = Tile19;
        buttons[2][3] = Tile20;
        buttons[2][4] = Tile21;
        buttons[2][5] = Tile22;
        buttons[2][6] = Tile23;
        buttons[2][7] = Tile24;

        buttons[3][0] = Tile25;
        buttons[3][1] = Tile26;
        buttons[3][2] = Tile27;
        buttons[3][3] = Tile28;
        buttons[3][4] = Tile29;
        buttons[3][5] = Tile30;
        buttons[3][6] = Tile31;
        buttons[3][7] = Tile32;

        buttons[4][0] = Tile33;
        buttons[4][1] = Tile34;
        buttons[4][2] = Tile35;
        buttons[4][3] = Tile36;
        buttons[4][4] = Tile37;
        buttons[4][5] = Tile38;
        buttons[4][6] = Tile39;
        buttons[4][7] = Tile40;

        buttons[5][0] = Tile41;
        buttons[5][1] = Tile42;
        buttons[5][2] = Tile43;
        buttons[5][3] = Tile44;
        buttons[5][4] = Tile45;
        buttons[5][5] = Tile46;
        buttons[5][6] = Tile47;
        buttons[5][7] = Tile48;

        buttons[6][0] = Tile49;
        buttons[6][1] = Tile50;
        buttons[6][2] = Tile51;
        buttons[6][3] = Tile52;
        buttons[6][4] = Tile53;
        buttons[6][5] = Tile54;
        buttons[6][6] = Tile55;
        buttons[6][7] = Tile56;

        buttons[7][0] = Tile57;
        buttons[7][1] = Tile58;
        buttons[7][2] = Tile59;
        buttons[7][3] = Tile60;
        buttons[7][4] = Tile61;
        buttons[7][5] = Tile62;
        buttons[7][6] = Tile63;
        buttons[7][7] = Tile64;

        //instantiate a click listener and use it for each button's addActionListener
        buttonClickListener = new ClickListener();

        boolean flip = false;
        int count = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setName("Tile" + count); //set it's name for use in other code
                buttons[i][j].setBorder(null);
                buttons[i][j].addActionListener(buttonClickListener); //use the same listener for all buttons
                buttons[i][j].setSize(new Dimension(80, 80));

                if (flip) {
                    buttons[i][j].setBackground(Color.BLACK); //sets the button background colour to black or white
                } else {
                    buttons[i][j].setBackground(Color.WHITE);
                }

                if (i <= 1 || i >= 6) { //rows 0,1, 6, 7 have pieces
                    //buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon" + count + ".png"));
                } else { //rest of the rows have black and white
                    if (flip) {
                        buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\blackSquare.jpg")); //sets the button icon to black or white
                    } else {
                        buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\whitesquare.png"));
                    }
                }

                flip = !flip; //flip so the next square color is inverse

                count++;
            }
            flip = !flip; //do an extra flip after the row is complete so the next row is inverse
        }

        for (int i = 0; i < 8; i++) { //loops through the board
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = 0;
            }
        }
        //sets the values of the black pieces that aren't pawns
        chessBoard[0][0] = -5;
        chessBoard[0][1] = -4;
        chessBoard[0][2] = -3;
        chessBoard[0][3] = -100;
        chessBoard[0][4] = -101;
        chessBoard[0][5] = -3;
        chessBoard[0][6] = -4;
        chessBoard[0][7] = -5;

        //sets the values of the black pawns
        chessBoard[1][0] = -1;
        chessBoard[1][1] = -1;
        chessBoard[1][2] = -1;
        chessBoard[1][3] = -1;
        chessBoard[1][4] = -1;
        chessBoard[1][5] = -1;
        chessBoard[1][6] = -1;
        chessBoard[1][7] = -1;

        //sets the values of the white pieces that aren't pawns
        chessBoard[7][0] = 5;
        chessBoard[7][1] = 4;
        chessBoard[7][2] = 3;
        chessBoard[7][3] = 100;
        chessBoard[7][4] = 101;
        chessBoard[7][5] = 3;
        chessBoard[7][6] = 4;
        chessBoard[7][7] = 5;

        //sets the values of the white pawns
        chessBoard[6][0] = 1;
        chessBoard[6][1] = 1;
        chessBoard[6][2] = 1;
        chessBoard[6][3] = 1;
        chessBoard[6][4] = 1;
        chessBoard[6][5] = 1;
        chessBoard[6][6] = 1;
        chessBoard[6][7] = 1;

        OutputStream fout = null;
        OutputStream bout = null;
        OutputStreamWriter out = null;
        try {
            //check to see if the high score file exists, if not create one
            java.io.File f = new java.io.File("highscores.xml");
            if (!f.exists()) {
                //go ahead and create using existing code
                fout = new FileOutputStream("highscores.xml"); //creates a new file with the name hello.xml
                bout = new BufferedOutputStream(fout); //this file will be written to
                out = new OutputStreamWriter(bout, "8859_1"); //defines it to me XML with the ISO 8859_1 encoding style

                //the code below writes the to the hello.xml file
                out.write("<?xml version=\"1.0\" "); //defines the XML coding
                out.write("encoding=\"ISO-8859-1\"?>\r\n"); //defines the XML coding
                out.write("<highscores>\r\n"); //opens the root element
                out.write("  <highscore>\r\n"); //these are test scores
                out.write("    <score>100</score>\r\n"); //opens and closes the child element of the root
                out.write("    <name>Test</name>\r\n"); //opens and closes the child element of the root
                out.write("    <time>2017-05-04 13:13:00</time>\r\n"); //opens and closes the child element of the root
                out.write("  </highscore>\r\n");
                out.write("  <highscore>\r\n");
                out.write("    <score>4</score>\r\n"); //opens and closes the child element of the root
                out.write("    <name>Daniel</name>\r\n"); //opens and closes the child element of the root
                out.write("    <time>2017-05-06 10:10:00</time>\r\n"); //opens and closes the child element of the root
                out.write("  </highscore>\r\n");
                out.write("</highscores>\r\n"); //closes the root element

                out.flush();
                out.close(); //closes the file
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("This VM does not support the Latin-1 character set."); //outputs an error message
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {
            }
            try {
                if (bout != null) {
                    bout.close();
                }
            } catch (Exception e) {
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tile1 = new javax.swing.JButton();
        Tile2 = new javax.swing.JButton();
        Tile3 = new javax.swing.JButton();
        Tile4 = new javax.swing.JButton();
        Tile5 = new javax.swing.JButton();
        Tile6 = new javax.swing.JButton();
        Tile7 = new javax.swing.JButton();
        Tile8 = new javax.swing.JButton();
        Tile9 = new javax.swing.JButton();
        Tile10 = new javax.swing.JButton();
        Tile11 = new javax.swing.JButton();
        Tile12 = new javax.swing.JButton();
        Tile13 = new javax.swing.JButton();
        Tile14 = new javax.swing.JButton();
        Tile15 = new javax.swing.JButton();
        Tile16 = new javax.swing.JButton();
        Tile17 = new javax.swing.JButton();
        Tile18 = new javax.swing.JButton();
        Tile19 = new javax.swing.JButton();
        Tile20 = new javax.swing.JButton();
        Tile21 = new javax.swing.JButton();
        Tile22 = new javax.swing.JButton();
        Tile23 = new javax.swing.JButton();
        Tile24 = new javax.swing.JButton();
        Tile25 = new javax.swing.JButton();
        Tile26 = new javax.swing.JButton();
        Tile27 = new javax.swing.JButton();
        Tile28 = new javax.swing.JButton();
        Tile29 = new javax.swing.JButton();
        Tile30 = new javax.swing.JButton();
        Tile31 = new javax.swing.JButton();
        Tile32 = new javax.swing.JButton();
        Tile33 = new javax.swing.JButton();
        Tile34 = new javax.swing.JButton();
        Tile35 = new javax.swing.JButton();
        Tile36 = new javax.swing.JButton();
        Tile37 = new javax.swing.JButton();
        Tile38 = new javax.swing.JButton();
        Tile39 = new javax.swing.JButton();
        Tile40 = new javax.swing.JButton();
        Tile41 = new javax.swing.JButton();
        Tile42 = new javax.swing.JButton();
        Tile43 = new javax.swing.JButton();
        Tile44 = new javax.swing.JButton();
        Tile45 = new javax.swing.JButton();
        Tile46 = new javax.swing.JButton();
        Tile47 = new javax.swing.JButton();
        Tile48 = new javax.swing.JButton();
        Tile49 = new javax.swing.JButton();
        Tile50 = new javax.swing.JButton();
        Tile51 = new javax.swing.JButton();
        Tile52 = new javax.swing.JButton();
        Tile53 = new javax.swing.JButton();
        Tile54 = new javax.swing.JButton();
        Tile55 = new javax.swing.JButton();
        Tile56 = new javax.swing.JButton();
        Tile57 = new javax.swing.JButton();
        Tile58 = new javax.swing.JButton();
        Tile59 = new javax.swing.JButton();
        Tile60 = new javax.swing.JButton();
        Tile61 = new javax.swing.JButton();
        Tile62 = new javax.swing.JButton();
        Tile63 = new javax.swing.JButton();
        Tile64 = new javax.swing.JButton();
        WhiteMovesLabel = new javax.swing.JLabel();
        BlackMovesLabel = new javax.swing.JLabel();
        BlackPiecesTakenLabel = new javax.swing.JLabel();
        WhitePiecesTakenLabel = new javax.swing.JLabel();
        BlackStatsLabel = new javax.swing.JLabel();
        WhiteStatsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(106, 64, 64));
        setForeground(new java.awt.Color(153, 0, 0));

        Tile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon22.png"))); // NOI18N
        Tile1.setBorder(null);

        Tile2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon9.png"))); // NOI18N
        Tile2.setBorder(null);

        Tile3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon2.png"))); // NOI18N
        Tile3.setBorder(null);

        Tile4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon17.png"))); // NOI18N
        Tile4.setBorder(null);

        Tile5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon6.png"))); // NOI18N
        Tile5.setBorder(null);

        Tile6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon1.png"))); // NOI18N
        Tile6.setBorder(null);

        Tile7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon10.png"))); // NOI18N
        Tile7.setBorder(null);

        Tile8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon21.png"))); // NOI18N
        Tile8.setBorder(null);

        Tile9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon13.png"))); // NOI18N
        Tile9.setBorder(null);

        Tile10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon14.png"))); // NOI18N
        Tile10.setBorder(null);

        Tile11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon13.png"))); // NOI18N
        Tile11.setBorder(null);

        Tile12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon14.png"))); // NOI18N
        Tile12.setBorder(null);

        Tile13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon13.png"))); // NOI18N
        Tile13.setBorder(null);

        Tile14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon14.png"))); // NOI18N
        Tile14.setBorder(null);

        Tile15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon13.png"))); // NOI18N
        Tile15.setBorder(null);

        Tile16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon14.png"))); // NOI18N
        Tile16.setBorder(null);

        Tile17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile17.setBorder(null);

        Tile18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile18.setBorder(null);

        Tile19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile19.setBorder(null);

        Tile20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile20.setBorder(null);

        Tile21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile21.setBorder(null);

        Tile22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile22.setBorder(null);

        Tile23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile23.setBorder(null);

        Tile24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile24.setBorder(null);

        Tile25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile25.setBorder(null);

        Tile26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile26.setBorder(null);

        Tile27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile27.setBorder(null);

        Tile28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile28.setBorder(null);

        Tile29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile29.setBorder(null);

        Tile30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile30.setBorder(null);

        Tile31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile31.setBorder(null);

        Tile32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile32.setBorder(null);

        Tile33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile33.setBorder(null);

        Tile34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile34.setBorder(null);

        Tile35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile35.setBorder(null);

        Tile36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile36.setBorder(null);

        Tile37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile37.setBorder(null);

        Tile38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile38.setBorder(null);

        Tile39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile39.setBorder(null);

        Tile40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile40.setBorder(null);

        Tile41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile41.setBorder(null);

        Tile42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile42.setBorder(null);

        Tile43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile43.setBorder(null);

        Tile44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile44.setBorder(null);

        Tile45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile45.setBorder(null);

        Tile46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile46.setBorder(null);

        Tile47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackSquare.jpg"))); // NOI18N
        Tile47.setBorder(null);

        Tile48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitesquare.png"))); // NOI18N
        Tile48.setBorder(null);

        Tile49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon16.png"))); // NOI18N
        Tile49.setBorder(null);

        Tile50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon15.png"))); // NOI18N
        Tile50.setBorder(null);

        Tile51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon16.png"))); // NOI18N
        Tile51.setBorder(null);

        Tile52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon15.png"))); // NOI18N
        Tile52.setBorder(null);

        Tile53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon16.png"))); // NOI18N
        Tile53.setBorder(null);

        Tile54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon15.png"))); // NOI18N
        Tile54.setBorder(null);

        Tile55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon16.png"))); // NOI18N
        Tile55.setBorder(null);

        Tile56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon15.png"))); // NOI18N
        Tile56.setBorder(null);

        Tile57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon23.png"))); // NOI18N
        Tile57.setBorder(null);

        Tile58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon12.png"))); // NOI18N
        Tile58.setBorder(null);

        Tile59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon3.png"))); // NOI18N
        Tile59.setBorder(null);

        Tile60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon20.png"))); // NOI18N
        Tile60.setBorder(null);

        Tile61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon7.png"))); // NOI18N
        Tile61.setBorder(null);

        Tile62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon4.png"))); // NOI18N
        Tile62.setBorder(null);

        Tile63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon11.png"))); // NOI18N
        Tile63.setBorder(null);

        Tile64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon24.png"))); // NOI18N
        Tile64.setBorder(null);

        WhiteMovesLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        WhiteMovesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WhiteMovesLabel.setText("White Moves: 0");
        WhiteMovesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BlackMovesLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BlackMovesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlackMovesLabel.setText("Black Moves: 0");
        BlackMovesLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BlackPiecesTakenLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BlackPiecesTakenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlackPiecesTakenLabel.setText("Black Pieces Lost: 0");
        BlackPiecesTakenLabel.setToolTipText("");
        BlackPiecesTakenLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        WhitePiecesTakenLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        WhitePiecesTakenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WhitePiecesTakenLabel.setText("White Pieces Lost: 0");
        WhitePiecesTakenLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BlackStatsLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        BlackStatsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlackStatsLabel.setText("Black Stats:");
        BlackStatsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BlackStatsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        WhiteStatsLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        WhiteStatsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WhiteStatsLabel.setText("White Stats:");
        WhiteStatsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        WhiteStatsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Tile41)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile42)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile43)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile44)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile45)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile46)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile47)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tile48))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile24))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Tile9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile16))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Tile1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Tile8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Tile49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile56))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tile57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tile64)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WhiteMovesLabel)
                    .addComponent(BlackMovesLabel)
                    .addComponent(BlackPiecesTakenLabel)
                    .addComponent(WhitePiecesTakenLabel)
                    .addComponent(BlackStatsLabel)
                    .addComponent(WhiteStatsLabel))
                .addGap(122, 122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile7)
                                .addComponent(Tile8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile5)
                                .addComponent(Tile6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile3)
                                .addComponent(Tile4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile1)
                                .addComponent(Tile2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tile9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile10)
                                .addComponent(Tile11))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile12)
                                .addComponent(Tile13))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile14)
                                .addComponent(Tile15))
                            .addComponent(Tile16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile23)
                                .addComponent(Tile24))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile21)
                                .addComponent(Tile22))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile19)
                                .addComponent(Tile20))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile17)
                                .addComponent(Tile18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tile25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile26)
                                .addComponent(Tile27))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile28)
                                .addComponent(Tile29))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile30)
                                .addComponent(Tile31))
                            .addComponent(Tile32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile33)
                                .addComponent(Tile34))
                            .addComponent(Tile35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile36)
                                .addComponent(Tile37))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile38)
                                .addComponent(Tile39))
                            .addComponent(Tile40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tile41)
                            .addComponent(Tile42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile47)
                                .addComponent(Tile48))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile45)
                                .addComponent(Tile46))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile43)
                                .addComponent(Tile44)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile49)
                                .addComponent(Tile50))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Tile51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Tile52)
                                    .addComponent(Tile53))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Tile54)
                                    .addComponent(Tile55))
                                .addComponent(Tile56)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tile57)
                            .addComponent(Tile58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile63)
                                .addComponent(Tile64))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile61)
                                .addComponent(Tile62))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tile59)
                                .addComponent(Tile60))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(66, Short.MAX_VALUE)
                        .addComponent(BlackStatsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(BlackMovesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BlackPiecesTakenLabel)
                        .addGap(477, 477, 477)
                        .addComponent(WhiteStatsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(WhiteMovesLabel)
                        .addGap(26, 26, 26)
                        .addComponent(WhitePiecesTakenLabel)))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        Pre-Condition: Called upon when a player is moving a knight. Takes the original x and y cords of the knight and its final location. It also takes the array of all pieces
        Post-Condition: Tests whether it is a correct movement and if so moves the knight, updating the array and icons
     */
    public boolean knightMovement(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard, boolean checkTest) {
        boolean friendlyPieceLocation = true;
        int locationSum = xPos + yPos; //determines the colour of the tile
        int newLocationSum = newXPos + newYPos; //determines the colour of the new tile
        if (pieceColour == "white") {
            if (chessBoard[newYPos][newXPos] <= 0) { //if its a negative value it is a black piece. 0 is an empty piece
                friendlyPieceLocation = false;
            }
        } else if (pieceColour == "black") {
            if (chessBoard[newYPos][newXPos] >= 0) { //if its a positive value it is a white piece. 0 is an empty piece
                friendlyPieceLocation = false;
            }
        }

        if (chessBoard[newYPos][newXPos] == -101 || chessBoard[newYPos][newXPos] == 101 && checkTest == true) { //checks to make sure the knight can't take a king
            friendlyPieceLocation = true;
        }
        //checks if the knight is moving to a valid location using its L-shaped movement
        if ((Math.abs(xPos - newXPos) == 2 && Math.abs(yPos - newYPos) == 1) || (Math.abs(xPos - newXPos) == 1) && Math.abs(yPos - newYPos) == 2) {
            /*
            if enemyPieceLocation is true then remove that piece. Add it to the score.
            move the knight
            check if it is on a black or white tile and update the icon accordingly
                find this by adding up the x and y points on the array. If its even its white if its odd its black
            update the icons
             */
            if (friendlyPieceLocation == false) { //if there is no friendly piece in the new location
                if (pieceColour == "white") { //if its a white piece
                    chessBoard[yPos][xPos] = 0; //sets the new location as a white knight and sets the old location as 0
                    chessBoard[newYPos][newXPos] = 4;
                    postMoveCheckTest = true;
                    for (int k = 0; k < 8; k++) { //loops through the board
                        for (int l = 0; l < 8; l++) {
                            if (chessBoard[k][l] == 101) {
                                isCheck = kingCheck(0, 0, l, k, chessBoard); //tests for check for the king
                            }
                        }
                    }
                    postMoveCheckTest = false;
                    if (isCheck == true) { //if it is in check it outputs a message and resets the variables
                        if (checkTest == true) {
                            return false;
                        }
                        JOptionPane.showMessageDialog(null, "That is not a valid move");
                        chessBoard[yPos][xPos] = 4;
                        chessBoard[newYPos][newXPos] = 0;
                        whiteMove = true;
                    } else {
                        locationSwitch(locationSum); //if it is not in check it updates the icons
                        newLocationSwitch(newLocationSum, chessBoard);
                    }

                } else if (pieceColour == "black") { //same code as above except for black pieces
                    chessBoard[yPos][xPos] = 0;
                    chessBoard[newYPos][newXPos] = -4;
                    postMoveCheckTest = true;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (chessBoard[k][l] == -101) {
                                isCheck = kingCheck(0, 0, l, k, chessBoard);
                            }
                        }
                    }
                    postMoveCheckTest = false;
                    if (isCheck == true) {
                        if (checkTest == true) {
                            return false;
                        }
                        JOptionPane.showMessageDialog(null, "That is not a valid move");
                        chessBoard[yPos][xPos] = -4;
                        chessBoard[newYPos][newXPos] = 0;
                        whiteMove = false;

                    } else {
                        locationSwitch(locationSum);
                        newLocationSwitch(newLocationSum, chessBoard);
                    }
                }
            } else { //if it is an illegal move output a message
                if (checkTest == true) {
                    return false;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move");
                if (whiteMove == true) { //resets the variables for a misplay
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
            }

        } else { //if it is an illegal move output a message
            if (checkTest == true) {
                return false;
            }
            JOptionPane.showMessageDialog(null, "That is not a valid move");
            if (whiteMove == true) { //resets the variables for a misplay
                whiteMove = false;
            } else {
                whiteMove = true;
            }
        }
        return true;
    }

    /*
        Pre-Condition: Called upon when a player is moving a rook or queen. Takes the original x and y cords of the rook and its final location. It also takes the array of all pieces and 2 boolean
                       values that are used when a queen is moving or to test for checks
        Post-Condition: Tests whether it is a correct movement and if so moves the rook, updating the array and icons
     */
    public boolean rookMovement(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard, boolean queenMove, boolean rookTestCheck, boolean checkTest) {
        int locationSum = xPos + yPos;
        int newLocationSum = newXPos + newYPos;
        boolean pieceObstruction = false;
        /*
                check if there is an enemy piece
                    if its along its path then say its an invalid move
                    if its at the final position then take the piece and add the score
                move the piece
                update the icons
         */
        if (xPos == newXPos) //if the rook is moving along the y axis
        {
            for (int i = 1; i < Math.abs(newYPos - yPos); i++) //loops through the tiles of the board that the rook will pass through
            {
                if (newYPos > yPos) //if the rooks new position is higher than its old position
                {
                    if (chessBoard[yPos + i][xPos] != 0) //if there is a piece in the way set the boolean to true
                    {
                        pieceObstruction = true;
                    }
                } else if (newYPos < yPos) //if the rooks new position is lower than its old position
                {
                    if (chessBoard[yPos - i][xPos] != 0) //if there is a piece in the way set the boolean to true
                    {
                        pieceObstruction = true;
                    }
                }
            }
        } else if (yPos == newYPos) //if the rook is moving along the x axis
        {
            for (int i = 1; i < Math.abs(newXPos - xPos); i++) //loops through the tiles of the board that the rook will pass through
            {
                if (newXPos > xPos) //if the rooks new position is higher than its old position
                {
                    if (chessBoard[yPos][xPos + i] != 0) //if there is a piece in the way set the boolean to true
                    {
                        pieceObstruction = true;
                    }
                } else if (newXPos < xPos) //if the rooks new position is lower than its old position
                {
                    if (chessBoard[yPos][xPos - i] != 0) //if there is a piece in the way set the boolean to true
                    {
                        pieceObstruction = true;
                    }
                }
            }
        }

        if (chessBoard[newYPos][newXPos] > 0 && pieceColour == "white" && postMoveCheckTest == false) { //if it is a white piece and there is a white piece at its final location
            pieceObstruction = true;
        } else if (chessBoard[newYPos][newXPos] < 0 && pieceColour == "black" && postMoveCheckTest == false) { //if it is a black piece and there is a black piece at its final location
            pieceObstruction = true;
        }

        if ((chessBoard[newYPos][newXPos] == -101 || chessBoard[newYPos][newXPos] == 101) && postMoveCheckTest == false) { //checks to make sure the rook can't take the king
            pieceObstruction = true;
        }

        //checks if the new position is in either the same row or the same column
        if (((xPos == newXPos && yPos != newYPos) || (xPos != newXPos && yPos == newYPos)) && pieceObstruction == false) {

            if (rookTestCheck == true || postMoveCheckTest == true) {
                return true;
            }
            if (pieceColour == "white") {
                chessBoard[yPos][xPos] = 0;
                if (queenMove == false) {
                    chessBoard[newYPos][newXPos] = 5; //updates the array values
                } else { //if the queen is moving set its value to 100
                    chessBoard[newYPos][newXPos] = 100;
                }

                postMoveCheckTest = true;
                for (int k = 0; k < 8; k++) { //loops through the board
                    for (int l = 0; l < 8; l++) {
                        if (chessBoard[k][l] == 101) {
                            isCheck = kingCheck(0, 0, l, k, chessBoard); //tests for check for the king
                        }
                    }
                }
                postMoveCheckTest = false;
                if (isCheck == true) { //if it is in check it outputs a message and resets the variables
                    if (queenMove == false) {
                        chessBoard[yPos][xPos] = 5; //resets the array
                    } else {
                        chessBoard[yPos][xPos] = 100;
                    }
                    chessBoard[newYPos][newXPos] = 0;
                    if (checkTest == true) {
                        return false;
                    }
                    JOptionPane.showMessageDialog(null, "That is not a valid move");
                    whiteMove = true;
                } else {
                    locationSwitch(locationSum); //updates the icons
                    newLocationSwitch(newLocationSum, chessBoard);
                }
            } else { //if its a black piece
                chessBoard[yPos][xPos] = 0; //it moves the piece
                if (queenMove == false) {
                    chessBoard[newYPos][newXPos] = -5;
                } else {
                    chessBoard[newYPos][newXPos] = -100;
                }

                postMoveCheckTest = true; //checks for check
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (chessBoard[k][l] == -101) {
                            isCheck = kingCheck(0, 0, l, k, chessBoard);
                        }
                    }
                }
                postMoveCheckTest = false;
                if (isCheck == true) { //if the player is in check it resets the move, moving the piece back to its original location
                    if (queenMove == false) {
                        chessBoard[yPos][xPos] = -5;
                    } else {
                        chessBoard[yPos][xPos] = -100;
                    }
                    chessBoard[newYPos][newXPos] = 0;
                    if (checkTest == true) {
                        return false;
                    }
                    JOptionPane.showMessageDialog(null, "That is not a valid move");

                    whiteMove = false;
                } else {
                    locationSwitch(locationSum); //if they're not in check it updates the icons
                    newLocationSwitch(newLocationSum, chessBoard);
                }
            }

        } else { //if its not a valid move
            if (rookTestCheck == false) {

                if (checkTest == true) {
                    return false;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move"); //outputs a message
                if (whiteMove == true) { //resets the variables for a misplay
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    /*
        Pre-Condition: Called upon when a player is moving a bishop or queen. Takes the original x and y cords of the bishop and its final location. It also takes the array of all pieces and 2 boolean
                       values that are used when a queen is moving or to test for checks
        Post-Condition: Tests whether it is a correct movement and if so moves the bishop, updating the array and icons
     */
    public boolean bishopMovement(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard, boolean queenMove, boolean bishopTestCheck, boolean checkTest, boolean checkMateTest) {
        int locationSum = xPos + yPos; //if there is an even sum it will be white
        int newLocationSum = newXPos + newYPos; //if there is an odd sum it will be black
        boolean pieceObstruction = false;
        //if locationsum is equal to newlocationsum then that means its moving along the same diagonal

        if (Math.abs(newXPos - xPos) == Math.abs(newYPos - yPos)) //if it is going diagonal
        {
            if (newXPos > xPos) {
                if (newYPos > yPos) //if its going diagonally from top left to bottom right
                {
                    for (int i = 1; i < Math.abs(newXPos - xPos); i++) //loops through all the tiles from the start to the end of its movement
                    {
                        if (chessBoard[yPos + i][xPos + i] != 0) //if there is a piece in the way
                        {
                            pieceObstruction = true;
                        }
                    }
                } else if (newYPos < yPos) //if its going diagonally from bottom left to top right
                {
                    for (int i = 1; i < Math.abs(newXPos - xPos); i++) //loops through the tiles
                    {
                        if (chessBoard[yPos - i][xPos + i] != 0) //if there is a piece in the way
                        {
                            pieceObstruction = true;
                        }
                    }
                }
            } else if (newXPos < xPos) {
                if (newYPos > yPos) //if its going diagonally from top right to bottom left
                {
                    for (int i = 1; i < Math.abs(newXPos - xPos); i++) //loops through all the tiles from the start to the end of its movement
                    {
                        if (chessBoard[yPos + i][xPos - i] != 0) //if there is a piece in the way
                        {
                            pieceObstruction = true;
                        }
                    }
                } else if (newYPos < yPos) //if its going diagonally from bottom right to top left
                {
                    for (int i = 1; i < Math.abs(newXPos - xPos); i++) //loops through the tiles
                    {
                        if (chessBoard[yPos - i][xPos - i] != 0) //if there is a piece in the way
                        {
                            pieceObstruction = true;
                        }
                    }
                }
            }

            if (chessBoard[newYPos][newXPos] > 0 && pieceColour == "white" && postMoveCheckTest == false) { //if it has a friendly piece at its final location
                pieceObstruction = true; //there is an obstruction
            } else if (chessBoard[newYPos][newXPos] < 0 && pieceColour == "black" && postMoveCheckTest == false) { //if it has a friendly piece at its final location
                pieceObstruction = true;
            }

            if ((chessBoard[newYPos][newXPos] == -101 || chessBoard[newYPos][newXPos] == 101) && postMoveCheckTest == false) { //if it has a king at its final location
                pieceObstruction = true;

            }

            if (pieceObstruction == false) { //if there are no obstructions
                if (bishopTestCheck == true || postMoveCheckTest == true) { //if its checking for check return true
                    return true;
                }
                if (pieceColour == "white") { //if its a white bishop
                    chessBoard[yPos][xPos] = 0; //clears its value
                    if (queenMove == false) {
                        chessBoard[newYPos][newXPos] = 3; //updates the array
                    } else {
                        chessBoard[newYPos][newXPos] = 100;
                    }
                    postMoveCheckTest = true;
                    for (int k = 0; k < 8; k++) { //loops through the board
                        for (int l = 0; l < 8; l++) {
                            if (chessBoard[k][l] == 101) {
                                isCheck = kingCheck(0, 0, l, k, chessBoard); //tests for check for the king
                            }
                        }
                    }
                    postMoveCheckTest = false;
                    if (isCheck == true) { //if it is in check it outputs a message and resets the variables
                        if (queenMove == false) {
                            chessBoard[yPos][xPos] = 3; //updates the array
                        } else {
                            chessBoard[yPos][xPos] = 100;
                        }
                        chessBoard[newYPos][newXPos] = 0;
                        if (checkTest == true) {
                            return false;
                        }
                        JOptionPane.showMessageDialog(null, "That is not a valid move");
                        whiteMove = true;
                    } else {
                        if (checkTest == true && checkMateTest == true) {
                            if (queenMove == false) {
                                chessBoard[yPos][xPos] = 3; //updates the array
                            } else {
                                chessBoard[yPos][xPos] = 100;
                            }
                            chessBoard[newYPos][newXPos] = checkPiece;
                            whiteMove = true;
                            return true;
                        }
                        locationSwitch(locationSum); //updates the icons
                        newLocationSwitch(newLocationSum, chessBoard);
                    }
                } else { //if its black (same code as above)
                    chessBoard[yPos][xPos] = 0;
                    if (queenMove == false) {
                        chessBoard[newYPos][newXPos] = -3;
                    } else {
                        chessBoard[newYPos][newXPos] = -100;
                    }
                    postMoveCheckTest = true;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (chessBoard[k][l] == -101) {
                                isCheck = kingCheck(0, 0, l, k, chessBoard);
                            }
                        }
                    }
                    postMoveCheckTest = false;
                    if (isCheck == true) {
                        if (queenMove == false) {
                            chessBoard[yPos][xPos] = -3;
                        } else {
                            chessBoard[yPos][xPos] = -100;
                        }
                        chessBoard[newYPos][newXPos] = 0;

                        if (checkTest == true) {
                            return false;
                        }
                        JOptionPane.showMessageDialog(null, "That is not a valid move");
                        whiteMove = false;
                    } else {
                        if (checkTest == true && checkMateTest) {
                            if (queenMove == false) {
                                chessBoard[yPos][xPos] = -3; //updates the array
                            } else {
                                chessBoard[yPos][xPos] = -100;
                            }
                            chessBoard[newYPos][newXPos] = checkPiece;
                            whiteMove = true;
                            return true;
                        }
                        locationSwitch(locationSum);
                        newLocationSwitch(newLocationSum, chessBoard);
                    }
                }
            } else { //if it is a false move output a message
                if (bishopTestCheck == false) {

                    if (checkTest == true) {
                        return false;
                    }
                    JOptionPane.showMessageDialog(null, "That is not a valid move");
                    if (whiteMove == true) { //resets the variables for a misplay
                        whiteMove = false;
                    } else {
                        whiteMove = true;
                    }
                }
                return false;
            }

        } else {

            if (checkTest == true) {
                return false;
            }
            JOptionPane.showMessageDialog(null, "That is not a valid move");
            if (whiteMove == true) { //resets the variables for a misplay
                whiteMove = false;

            } else {
                whiteMove = true;
            }
        }

        return true;
    }

    /*
        Pre-Condition: Called upon when a player is moving a king. Takes the original x and y cords of the king and its final location. It also takes the array of all pieces
        Post-Condition: Tests whether it is a correct movement and if so moves the king, updating the array and icons
     */
    public boolean kingMovement(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard, boolean checkTest) {
        boolean isCheck = false;
        int locationSum = xPos + yPos; //calculates the location sum
        int newLocationSum = newXPos + newYPos;
        int x = checkXPos;
        int y = checkYPos;

        //checks if the king is moving 1 tile adjacent to it
        if (((Math.abs(newXPos - xPos) == 1 && Math.abs(newYPos - yPos) == 1) || (Math.abs(newXPos - xPos) == 1 && Math.abs(newYPos - yPos) == 0) || (Math.abs(newXPos - xPos) == 0 && Math.abs(newYPos - yPos) == 1)) && ((pieceColour == "white" && chessBoard[newYPos][newXPos] <= 0) || (pieceColour == "black" && chessBoard[newYPos][newXPos] >= 0))) {
            if (pieceColour == "white") { //if its a white king
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = 101;
                whiteKingMoveCounter++;
            } else { //if its a black king
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = -101;
                blackKingMoveCounter++;
            }
            //here I call the function to test for check
            kingTestCheck = true;
            isCheck = kingCheck(newXPos, newYPos, newXPos, newYPos, chessBoard); //checks if the king is in check in its new location
            kingTestCheck = false;
            if (isCheck == true) { //if they're in check say its an invalid move
                if (checkTest == true) {
                    return false;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move. You would be moving your king into check");
                if (whiteMove == true) { //resets the variables for a misplay
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
                if (pieceColour == "white") { //if its a white king
                    chessBoard[yPos][xPos] = 101;
                    chessBoard[newYPos][newXPos] = 0;
                    whiteKingMoveCounter--;
                } else { //if its a black king
                    chessBoard[yPos][xPos] = -101;
                    chessBoard[newYPos][newXPos] = 0;
                    blackKingMoveCounter--;
                }

            } else { //if its not in check at its new location update the icons
                locationSwitch(locationSum);
                newLocationSwitch(newLocationSum, chessBoard);
            }
        } else if (checkTest == true) { //if they're in check and the piece is adjacent to the king
            for (int a = 0; a < 8; a++) { //loops through the board to find the piece and gets its coordinates
                for (int b = 0; b < 8; b++) {
                    if (chessBoard[a][b] > 0 && pieceColour == "black" && ((Math.abs(b - xPos) == 1 && Math.abs(a - yPos) == 1) || (Math.abs(b - xPos) == 1 && Math.abs(a - yPos) == 0) || (Math.abs(b - xPos) == 0 && Math.abs(a - yPos) == 1))) {
                        x = b;
                        y = a;
                        checkPiece = chessBoard[a][b];
                    } else if (chessBoard[a][b] < 0 && pieceColour == "white" && ((Math.abs(b - xPos) == 1 && Math.abs(a - yPos) == 1) || (Math.abs(b - xPos) == 1 && Math.abs(a - yPos) == 0) || (Math.abs(b - xPos) == 0 && Math.abs(a - yPos) == 1))) {
                        x = b;
                        y = a;
                        checkPiece = chessBoard[a][b];
                    }
                }
            }
            if (((Math.abs(x - xPos) == 1 && Math.abs(y - yPos) == 1) || (Math.abs(x - xPos) == 1 && Math.abs(y - yPos) == 0) || (Math.abs(x - xPos) == 0 && Math.abs(y - yPos) == 1)) && ((pieceColour == "white" && chessBoard[y][x] <= 0) || (pieceColour == "black" && chessBoard[y][x] >= 0))) {
                if (pieceColour == "white") { //if its a white king
                    chessBoard[yPos][xPos] = 0;
                    chessBoard[y][x] = 101;
                    whiteKingMoveCounter++;
                } else { //if its a black king
                    chessBoard[yPos][xPos] = 0;
                    chessBoard[y][x] = -101;
                    blackKingMoveCounter++;
                }
                //here I call the function to test for check
                kingTestCheck = true;
                isCheck = kingCheck(newXPos, newYPos, newXPos, newYPos, chessBoard); //checks if the king is in check in its new location
                kingTestCheck = false;
                if (isCheck == true) { //if they're in check say its an invalid move
                    if (checkTest == true) {
                        return false;
                    }
                    JOptionPane.showMessageDialog(null, "That is not a valid move. You would be moving your king into check");
                    if (whiteMove == true) { //resets the variables for a misplay
                        whiteMove = false;
                    } else {
                        whiteMove = true;
                    }
                    if (pieceColour == "white") { //if its a white king
                        chessBoard[yPos][xPos] = 101;
                        chessBoard[newYPos][newXPos] = 0;
                        whiteKingMoveCounter--;
                    } else { //if its a black king
                        chessBoard[yPos][xPos] = -101;
                        chessBoard[newYPos][newXPos] = 0;
                        blackKingMoveCounter--;
                    }

                } else { //if its not in check at its new location
                    if (pieceColour == "white") {
                        chessBoard[yPos][xPos] = 101;
                    } else {
                        chessBoard[yPos][xPos] = -101;
                    }
                    chessBoard[y][x] = checkPiece;
                    return false;
                }

            }
            //the following checks for castling
        } else if ((pieceColour == "white" && whiteKingMoveCounter == 0) && (chessBoard[newYPos][newXPos] == 0)) {  //if the king hasn't moved and there is no piece at its final location
            //checks for the right side white castle
            if ((((newXPos - xPos == 2 && chessBoard[yPos][xPos + 1] == 0) && kingCheck(xPos, yPos, xPos + 1, yPos, chessBoard) == false) && kingCheck(xPos, yPos, newXPos, newYPos, chessBoard) == false) && chessBoard[7][7] == 5) {
                locationSwitch(locationSum); //updates the icons and array
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = 101;
                whiteKingMoveCounter++; //king move counter
                newLocationSwitch(newLocationSum, chessBoard);
                //sets the location of the rook
                location1 = "Tile64";
                location2 = "Tile62";
                locationSum = 14;
                newLocationSum = 12;
                locationSwitch(locationSum); //updates and swaps the value of the rook
                chessBoard[7][7] = 0;
                chessBoard[7][5] = 5;
                newLocationSwitch(newLocationSum, chessBoard);
                //tests for the left side castle
                //all of the code below is the same as above
            } else if ((((((newXPos - xPos == -2 && chessBoard[yPos][xPos - 1] == 0) && chessBoard[yPos][xPos - 2] == 0) && chessBoard[yPos][xPos - 3] == 0) && kingCheck(xPos, yPos, xPos - 1, yPos, chessBoard) == false) && kingCheck(xPos, yPos, newXPos, newYPos, chessBoard) == false) && chessBoard[7][0] == 5) {
                locationSwitch(locationSum);
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = 101;
                whiteKingMoveCounter++;
                newLocationSwitch(newLocationSum, chessBoard);
                location1 = "Tile57";
                location2 = "Tile60";
                locationSum = 7;
                newLocationSum = 10;
                locationSwitch(locationSum);
                chessBoard[7][0] = 0;
                chessBoard[7][3] = 5;
                newLocationSwitch(newLocationSum, chessBoard);

            } else {
                if (checkTest == true) {
                    return false;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move");
                if (whiteMove == true) { //resets the variables for a misplay
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
            }
            //the code below is still for castling. Check the comments above for clarification
        } else if ((pieceColour == "black" && blackKingMoveCounter == 0) && (chessBoard[newYPos][newXPos] == 0)) {
            if ((((newXPos - xPos == 2 && chessBoard[yPos][xPos + 1] == 0) && kingCheck(xPos, yPos, xPos + 1, yPos, chessBoard) == false) && kingCheck(xPos, yPos, newXPos, newYPos, chessBoard) == false) && chessBoard[0][7] == -5) {
                locationSwitch(locationSum);
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = -101;
                blackKingMoveCounter++;
                newLocationSwitch(newLocationSum, chessBoard);
                location1 = "Tile8";
                location2 = "Tile6";
                locationSum = 7;
                newLocationSum = 5;
                locationSwitch(locationSum);
                chessBoard[0][7] = 0;
                chessBoard[0][5] = -5;
                newLocationSwitch(newLocationSum, chessBoard);

            } else if ((((((newXPos - xPos == -2 && chessBoard[yPos][xPos - 1] == 0) && chessBoard[yPos][xPos - 2] == 0) && chessBoard[yPos][xPos - 3] == 0) && kingCheck(xPos, yPos, xPos - 1, yPos, chessBoard) == false) && kingCheck(xPos, yPos, newXPos, newYPos, chessBoard) == false) && chessBoard[0][0] == -5) {
                locationSwitch(locationSum);
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = -101;
                blackKingMoveCounter++;
                newLocationSwitch(newLocationSum, chessBoard);
                location1 = "Tile1";
                location2 = "Tile4";
                locationSum = 0;
                newLocationSum = 3;
                locationSwitch(locationSum);
                chessBoard[0][0] = 0;
                chessBoard[0][3] = -5;
                newLocationSwitch(newLocationSum, chessBoard);

            } else { //if its not a valid move it outputs a message
                if (checkTest == true) {
                    return false;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move");
                if (whiteMove == true) { //resets the variables for a misplay
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
                if (pieceColour == "white") { //if its a white king
                    chessBoard[yPos][xPos] = 101;
                    chessBoard[newYPos][newXPos] = 0;
                    whiteKingMoveCounter--;
                } else { //if its a black king
                    chessBoard[yPos][xPos] = -101;
                    chessBoard[newYPos][newXPos] = 0;
                    blackKingMoveCounter--;
                }
            }
        } else { //if its not a valid move it outputs a message
            if (checkTest == true) {
                return false;
            }
            JOptionPane.showMessageDialog(null, "That is not a valid move");
            if (whiteMove == true) { //resets the variables for a misplay
                whiteMove = false;
            } else {
                whiteMove = true;
            }
            if (pieceColour == "white") { //if its a white king
                chessBoard[yPos][xPos] = 101;
                chessBoard[newYPos][newXPos] = 0;
                whiteKingMoveCounter--;
            } else { //if its a black king
                chessBoard[yPos][xPos] = -101;
                chessBoard[newYPos][newXPos] = 0;
                blackKingMoveCounter--;
            }
        }
        return true;
    }

    /*
        Pre-Condition: Called upon when a player is moving a king. Takes the original x and y cords of the king and its final location. It also takes the array of all pieces
        Post-Condition: Checks all pieces on the board to see if they are putting the king into check. Returns a boolean where if it returns true it means that the king is in check
     */
    public boolean kingCheck(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard) {
        boolean isCheck = false;
        boolean checkTest = true;
        for (int i = 0; i < 8; i++) //loops through the board
        {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] > 0 && pieceColour == "black") { //if its a black king and a white piece
                    if ((chessBoard[i][j] == 1 && Math.abs(newXPos - j) == 1) && newYPos - i == -1) { //checks for check for pawns
                        isCheck = true;
                        checkXPos = j;
                        checkYPos = i;
                        checkPiece = 1;
                    } else if (chessBoard[i][j] == 4 && ((Math.abs(newXPos - j) == 2 && Math.abs(newYPos - i) == 1) || (Math.abs(newXPos - j) == 1 && Math.abs(newYPos - i) == 2))) { //checks for check for knights
                        isCheck = true;
                        checkXPos = j;
                        checkYPos = i;
                        checkPiece = 4;
                    } else if ((chessBoard[i][j] == 3 || chessBoard[i][j] == 100) && Math.abs(newXPos - j) == Math.abs(newYPos - i)) { //checks for checks for bishops and queens
                        boolean pieceObstruction = false;
                        //if locationsum is equal to newlocationsum then that means its moving along the same diagonal
                        if (Math.abs(newXPos - j) == Math.abs(newYPos - i)) //if it is going diagonal
                        {
                            if (newXPos > j) {
                                if (newYPos > i) //if its going diagonally from top left to bottom right
                                {
                                    for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through all the tiles from the start to the end of its movement
                                    {
                                        if (chessBoard[i + k][j + k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                } else if (newYPos < i) //if its going diagonally from bottom left to top right
                                {
                                    for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through the tiles
                                    {
                                        if (chessBoard[i - k][j + k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                }
                            } else if (newXPos < j) {
                                if (newYPos > i) //if its going diagonally from top right to bottom left
                                {
                                    for (int k = 1; k < Math.abs(newYPos - i); k++) //loops through all the tiles from the start to the end of its movement
                                    {
                                        if (chessBoard[i + k][j - k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                } else if (newYPos < i) //if its going diagonally from bottom right to top left
                                {
                                    for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through the tiles
                                    {
                                        if (chessBoard[i - k][j - k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                }
                            }
                        }

                        if (chessBoard[newYPos][newXPos] > 0 && pieceColour == "white" && postMoveCheckTest == false && kingTestCheck == false) { //if it has a friendly piece at its final location
                            pieceObstruction = true; //there is an obstruction
                        }

                        //if there is no piece blocking its path then it is in check
                        if (pieceObstruction == false) {
                            isCheck = true;
                        } else if (pieceObstruction == true && isCheck == false) {
                            isCheck = false;
                        }

                        //stores the coords of the piece
                        checkXPos = j;
                        checkYPos = i;
                        if (chessBoard[i][j] == 3) {
                            checkPiece = 3;
                        } else {
                            checkPiece = 100;
                        }

                    } else if ((chessBoard[i][j] == 5 || chessBoard[i][j] == 100) && (newXPos - j == 0 || newYPos - i == 0)) { //checks for checks of rooks and queens
                        boolean pieceObstruction = false;
                        if (j == newXPos) //if the rook is moving along the y axis
                        {
                            for (int k = 1; k < Math.abs(newYPos - i); k++) //loops through the tiles of the board that the rook will pass through
                            {
                                if (newYPos > i) //if the rooks new position is higher than its old position
                                {
                                    if (chessBoard[i + k][j] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                } else if (newYPos < i) //if the rooks new position is lower than its old position
                                {
                                    if (chessBoard[i - k][j] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                }
                            }
                        } else if (i == newYPos) //if the rook is moving along the x axis
                        {
                            for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through the tiles of the board that the rook will pass through
                            {
                                if (newXPos > j) //if the rooks new position is higher than its old position
                                {
                                    if (chessBoard[yPos][j + k] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                } else if (newXPos < j) //if the rooks new position is lower than its old position
                                {
                                    if (chessBoard[i][j - k] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                }
                            }
                        }

                        if (chessBoard[newYPos][newXPos] > 0 && pieceColour == "white" && postMoveCheckTest == false) { //if it is a white piece and there is a white piece at its final location
                            pieceObstruction = true;
                        }

                        //if there is no piece blocking its path then it is in check
                        if (pieceObstruction == false) {
                            isCheck = true;
                        } else if (pieceObstruction == true && isCheck == false) {
                            isCheck = false;
                        }

                        //stores the coords of the piece
                        checkXPos = j;
                        checkYPos = i;
                        if (chessBoard[i][j] == 5) {
                            checkPiece = 5;
                        } else {
                            checkPiece = 100;
                        }

                        //checks for checks of kings
                        //makes sure kings can't go within 1 tile of each other
                    } else if (chessBoard[i][j] == 101 && (((Math.abs(newXPos - j) == 1 && Math.abs(newYPos - i) == 1) || (newXPos - j == 0 && Math.abs(newYPos - i) == 1)) || (Math.abs(newXPos - j) == 1 && newYPos - i == 0))) {
                        isCheck = true;

                    }
                    //repeated code but for white pieces
                } else if (chessBoard[i][j] < 0 && pieceColour == "white") {
                    if ((chessBoard[i][j] == -1 && Math.abs(newXPos - j) == 1) && newYPos - i == 1) {
                        isCheck = true;
                        checkXPos = j;
                        checkYPos = i;
                        checkPiece = -1;
                    } else if (chessBoard[i][j] == -4 && ((Math.abs(newXPos - j) == 2 && Math.abs(newYPos - i) == 1) || (Math.abs(newXPos - j) == 1 && Math.abs(newYPos - i) == 2))) {
                        isCheck = true;
                        checkXPos = j;
                        checkYPos = i;
                        checkPiece = -4;
                    } else if ((chessBoard[i][j] == -3 || chessBoard[i][j] == -100) && Math.abs(newXPos - j) == Math.abs(newYPos - i)) {
                        boolean pieceObstruction = false;
                        //if locationsum is equal to newlocationsum then that means its moving along the same diagonal
                        if (Math.abs(newXPos - j) == Math.abs(newYPos - i)) //if it is going diagonal
                        {
                            if (newXPos > j) {
                                if (newYPos > i) //if its going diagonally from top left to bottom right
                                {
                                    for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through all the tiles from the start to the end of its movement
                                    {
                                        if (chessBoard[i + k][j + k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                } else if (newYPos < i) //if its going diagonally from bottom left to top right
                                {
                                    for (int k = 1; k < Math.abs(newYPos - j); k++) //loops through the tiles
                                    {
                                        if (chessBoard[i - k][j + k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                }
                            } else if (newXPos < j) {
                                if (newYPos > i) //if its going diagonally from top right to bottom left
                                {
                                    for (int k = 1; k < Math.abs(newYPos - i); k++) //loops through all the tiles from the start to the end of its movement
                                    {
                                        if (chessBoard[i + k][j - k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                } else if (newYPos < i) //if its going diagonally from bottom right to top left
                                {
                                    for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through the tiles
                                    {
                                        if (chessBoard[i - k][j - k] != 0) //if there is a piece in the way
                                        {
                                            pieceObstruction = true;
                                        }
                                    }
                                }
                            }
                        }

                        if (chessBoard[newYPos][newXPos] < 0 && pieceColour == "black" && postMoveCheckTest == false && kingTestCheck == false) { //if it has a friendly piece at its final location
                            pieceObstruction = true; //there is an obstruction
                        }

                        //if there is no piece blocking its path then it is in check
                        if (pieceObstruction == false) {
                            isCheck = true;
                        } else if (pieceObstruction == true && isCheck == false) {
                            isCheck = false;
                        }

                        //stores the coords of the piece
                        checkXPos = j;
                        checkYPos = i;
                        if (chessBoard[i][j] == -3) {
                            checkPiece = -3;
                        } else {
                            checkPiece = -100;
                        }

                    } else if ((chessBoard[i][j] == -5 || chessBoard[i][j] == -100) && (newXPos - j == 0 || newYPos - i == 0)) {
                        boolean pieceObstruction = false;
                        if (j == newXPos) //if the rook is moving along the y axis
                        {
                            for (int k = 1; k < Math.abs(newYPos - i); k++) //loops through the tiles of the board that the rook will pass through
                            {
                                if (newYPos > i) //if the rooks new position is higher than its old position
                                {
                                    if (chessBoard[i + k][j] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                } else if (newYPos < i) //if the rooks new position is lower than its old position
                                {
                                    if (chessBoard[i - k][j] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                }
                            }
                        } else if (i == newYPos) //if the rook is moving along the x axis
                        {
                            for (int k = 1; k < Math.abs(newXPos - j); k++) //loops through the tiles of the board that the rook will pass through
                            {
                                if (newXPos > j) //if the rooks new position is higher than its old position
                                {
                                    if (chessBoard[yPos][j + k] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                } else if (newXPos < j) //if the rooks new position is lower than its old position
                                {
                                    if (chessBoard[i][j - k] != 0) //if there is a piece in the way set the boolean to true
                                    {
                                        pieceObstruction = true;
                                    }
                                }
                            }
                        }

                        if (chessBoard[newYPos][newXPos] < 0 && pieceColour == "black" && postMoveCheckTest == false) { //if it is a white piece and there is a white piece at its final location
                            pieceObstruction = true;
                        }

                        //if there is no piece blocking its path then it is in check
                        if (pieceObstruction == false) {
                            isCheck = true;
                        } else if (pieceObstruction == true && isCheck == false) {
                            isCheck = false;
                        }

                        //stores the coords of the piece
                        checkXPos = j;
                        checkYPos = i;
                        if (chessBoard[i][j] == -5) {
                            checkPiece = -5;
                        } else {
                            checkPiece = -100;
                        }

                    } else if (chessBoard[i][j] == -101 && (((Math.abs(newXPos - j) == 1 && Math.abs(newYPos - i) == 1) || (newXPos - j == 0 && Math.abs(newYPos - i) == 1)) || (Math.abs(newXPos - j) == 1 && newYPos - i == 0))) {
                        isCheck = true;
                    }
                }
            }
        }

        trueCheck = isCheck;
        return isCheck;
    }

    /*
        Pre-Condition: Called upon when a player is moving a pawn. Takes the original x and y cords of the pawn and its final location. It also takes the array of all pieces
        Post-Condition: Tests whether it is a correct movement and if so moves the pawn, updating the array and icons
     */
    public boolean pawnMovement(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard, boolean checkTest) {
        int locationSum = xPos + yPos; //calculates the location sum
        int newLocationSum = newXPos + newYPos;
        boolean firstMove = false;
        boolean kingLocation = false;
        boolean validMove = true;
        boolean pawnMove = false;
        if (chessBoard[yPos][xPos] == 1) //if its a white pawn
        {
            if (yPos == 6) //it hasn't moved along its axis
            {
                firstMove = true;
            }
        } else //if its a black pawn
        {
            if (yPos == 1) {
                firstMove = true;
            }
        }

        if (chessBoard[newYPos][newXPos] == -101 || chessBoard[newYPos][newXPos] == 101 && checkTest == false) { //makes it so that the pawn can't the king
            kingLocation = true;
        }

        //checks if the pawn is moving in a straight line 1 tile or 2 tiles if it was the first move
        if (pieceColour == "black" && ((((yPos - newYPos == -1 || ((yPos - newYPos == -2 && firstMove == true)) && chessBoard[newYPos][newXPos] == 0) && chessBoard[yPos + 1][xPos] == 0) && xPos - newXPos == 0) && kingLocation == false)) {
            pawnMove = true;

            //same code as above but for white pieces
        } else if (pieceColour == "white" && ((((yPos - newYPos == 1 || ((yPos - newYPos == 2 && firstMove == true)) && chessBoard[newYPos][newXPos] == 0) && chessBoard[yPos - 1][xPos] == 0) && xPos - newXPos == 0) && kingLocation == false)) {
            pawnMove = true;
            //the code below is for taking pieces as a pawn
        } else if ((((chessBoard[newYPos][newXPos] > 0 && pieceColour == "black") && Math.abs(yPos - newYPos) == 1) && Math.abs(xPos - newXPos) == 1) && kingLocation == false) { //checks if its taking diagonal
            pawnMove = true;
            //same code as above
        } else if ((((chessBoard[newYPos][newXPos] < 0 && pieceColour == "white") && Math.abs(yPos - newYPos) == 1) && Math.abs(xPos - newXPos) == 1) && kingLocation == false) {
            pawnMove = true;
        } else { //if its an invalid move it outputs a message
            if (checkTest == true) {
                return false;
            }
            JOptionPane.showMessageDialog(null, "That is not a valid move");
            validMove = false;
            if (whiteMove == true) { //resets the variables for a misplay
                whiteMove = false;
            } else {
                whiteMove = true;
            }
        }

        if (pawnMove == true) {
            if (pieceColour == "white") { //if its a white pawn
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = 1;
                postMoveCheckTest = true;
                for (int k = 0; k < 8; k++) { //loops through the board
                    for (int l = 0; l < 8; l++) {
                        if (chessBoard[k][l] == 101) {
                            isCheck = kingCheck(0, 0, l, k, chessBoard); //tests for check for the king
                        }
                    }
                }
                postMoveCheckTest = false;
                if (isCheck == true) { //if it is in check it outputs a message and resets the variables
                    if (checkTest == true) {
                        return false;
                    }
                    JOptionPane.showMessageDialog(null, "That is not a valid move");
                    chessBoard[yPos][xPos] = 1;
                    chessBoard[newYPos][newXPos] = 0;
                    if (whiteMove == true) { //resets the variables for a misplay
                        whiteMove = false;
                    } else {
                        whiteMove = true;
                    }

                } else {
                    locationSwitch(locationSum); //updates the icons
                    newLocationSwitch(newLocationSum, chessBoard);
                }
            } else { //if its a black pawn
                chessBoard[yPos][xPos] = 0;
                chessBoard[newYPos][newXPos] = -1;
                postMoveCheckTest = true;
                for (int k = 0; k < 8; k++) { //loops through the board and checks for check
                    for (int l = 0; l < 8; l++) {
                        if (chessBoard[k][l] == -101) {
                            isCheck = kingCheck(0, 0, l, k, chessBoard);
                        }
                    }
                }
                postMoveCheckTest = false;
                if (isCheck == true) {
                    if (checkTest == true) {
                        return false;
                    }
                    JOptionPane.showMessageDialog(null, "That is not a valid move"); //outputs a message
                    chessBoard[yPos][xPos] = -1;
                    chessBoard[newYPos][newXPos] = 0;
                    if (whiteMove == true) { //resets the variables for a misplay
                        whiteMove = false;
                    } else {
                        whiteMove = true;
                    }

                } else {
                    locationSwitch(locationSum); //updates the icons if its a valid move
                    newLocationSwitch(newLocationSum, chessBoard);
                }
            }
        }

        //the following is code for pawn promotion
        if (pieceColour == "white" && newYPos == 0 && validMove == true) { //if the white pawn made it to the end
            Object[] options = {"knight", "bishop", "rook", "queen"}; //creates a dialog box that outputs the pieces it can promote into
            int n = JOptionPane.showOptionDialog(null, "What piece would you like to promote your pawn into?", "Pawn Promotion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            if (n == 0) { //if they chose knight set it to a knight
                chessBoard[newYPos][newXPos] = 4;
                newLocationSwitch(newLocationSum, chessBoard);
            } else if (n == 1) { //if they chose bishop set it to a bishop
                chessBoard[newYPos][newXPos] = 3;
                newLocationSwitch(newLocationSum, chessBoard);
            } else if (n == 2) { //if they chose rook set it to a rook
                chessBoard[newYPos][newXPos] = 5;
                newLocationSwitch(newLocationSum, chessBoard);
            } else if (n == 3) { //if they chose queen set it to a queen
                chessBoard[newYPos][newXPos] = 100;
                newLocationSwitch(newLocationSum, chessBoard);
            }
            //same code as above but for black pieces
        } else if (pieceColour == "black" && newYPos == 7 && validMove == true) {
            Object[] options = {"knight", "bishop", "rook", "queen"};
            int n = JOptionPane.showOptionDialog(null, "What piece would you like to promote your pawn into?", "Pawn Promotion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            if (n == 0) {
                chessBoard[newYPos][newXPos] = -4;
                newLocationSwitch(newLocationSum, chessBoard);
            } else if (n == 1) {
                chessBoard[newYPos][newXPos] = -3;
                newLocationSwitch(newLocationSum, chessBoard);
            } else if (n == 2) {
                chessBoard[newYPos][newXPos] = -5;
                newLocationSwitch(newLocationSum, chessBoard);
            } else if (n == 3) {
                chessBoard[newYPos][newXPos] = -100;
                newLocationSwitch(newLocationSum, chessBoard);
            }
        }

        return true;
    }

    /*
        Pre-Condition: Called upon when a player is moving a queen. Takes the original x and y cords of the queen and its final location. It also takes the array of all pieces
        Post-Condition: Calls upon the bishop and rook movement functions to move and update its icon
     */
    public boolean queenMovement(int xPos, int yPos, int newXPos, int newYPos, int[][] chessBoard, boolean checkTest, boolean checkMateTest) {

        if (xPos == newXPos || yPos == newYPos) { //if its going in a straight line it calls upon the rook function

            if (rookMovement(xPos, yPos, newXPos, newYPos, chessBoard, true, false, checkTest) == true) {
                return true;
            } else {
                if (whiteMove == true) {
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move");
                return false;
            }
        } else if (Math.abs(xPos - newXPos) == Math.abs(yPos - newYPos)) { //if its moving diagonally it calls upon the bishop function
            if (bishopMovement(xPos, yPos, newXPos, newYPos, chessBoard, true, false, checkTest, checkMateTest) == true) {
                return true;
            } else {
                if (whiteMove == true) {
                    whiteMove = false;
                } else {
                    whiteMove = true;
                }
                JOptionPane.showMessageDialog(null, "That is not a valid move");
                return false;
            }
        } else {
            if (whiteMove == true) {
                whiteMove = false;
            } else {
                whiteMove = true;
            }
            return false;
        }
    }

    /*
        Pre-Condition: Called upon when a player is a piece. Takes the sum of the axises of the original location
        Post-Condition: Determines if a location is a black or white tile and sets the button icon accordingly
     */
    public void locationSwitch(int locationSum) {
        for (int i = 0; i < 8; i++) { //loops through the array
            for (int j = 0; j < 8; j++) {
                if (buttons[i][j].getName().equals(location1) == true) {
                    if (locationSum % 2 == 0) { //if its even its a white tile
                        buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\whitesquare.png")); //sets the icon
                    } else if (locationSum % 2 == 1) { //if its odd its a black tile
                        buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\blackSquare.jpg")); //sets the icon
                    }
                }
            }
        }
    }

    /*
        Pre-Condition: Called upon when a player is moving a piece. Takes the sum of the axises of the final location and the array of all the pieces
        Post-Condition: Updates the new location with the icon of the piece on its respective tile
     */
    public void newLocationSwitch(int newLocationSum, int[][] chessBoard) {
        for (int i = 0; i < 8; i++) { //loops through the array
            for (int j = 0; j < 8; j++) {
                if (buttons[i][j].getName().equals(location2) == true) { //if the button name is the name of the end location button
                    if (newLocationSum % 2 == 0) {//if its even then its a white tile
                        if (chessBoard[i][j] == -3) { //updates the icon
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon2.png"));
                        } else if (chessBoard[i][j] == -4) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon10.png"));
                        } else if (chessBoard[i][j] == -5) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon22.png"));
                        } else if (chessBoard[i][j] == -1) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon14.png"));
                        } else if (chessBoard[i][j] == -100) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon18.png"));
                        } else if (chessBoard[i][j] == -101) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon6.png"));
                        } else if (chessBoard[i][j] == 3) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon4.png"));
                        } else if (chessBoard[i][j] == 4) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon12.png"));
                        } else if (chessBoard[i][j] == 5) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon24.png"));
                        } else if (chessBoard[i][j] == 1) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon16.png"));
                        } else if (chessBoard[i][j] == 100) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon20.png"));
                        } else if (chessBoard[i][j] == 101) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon8.png"));
                        }
                    } else { //updates the icons for a black tile
                        if (chessBoard[i][j] == -3) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon1.png"));
                        } else if (chessBoard[i][j] == -4) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon9.png"));
                        } else if (chessBoard[i][j] == -5) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon21.png"));
                        } else if (chessBoard[i][j] == -1) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon13.png"));
                        } else if (chessBoard[i][j] == -100) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon17.png"));
                        } else if (chessBoard[i][j] == -101) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon5.png"));
                        } else if (chessBoard[i][j] == 3) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon3.png"));
                        } else if (chessBoard[i][j] == 4) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon11.png"));
                        } else if (chessBoard[i][j] == 5) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon23.png"));
                        } else if (chessBoard[i][j] == 1) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon15.png"));
                        } else if (chessBoard[i][j] == 100) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon19.png"));
                        } else if (chessBoard[i][j] == 101) {
                            buttons[i][j].setIcon(new javax.swing.ImageIcon(imagePath + "\\Icon7.png"));
                        }
                    }
                }
            }
        }
    }

    /*
        Pre-Condition: Called upon when a player clicks a button
        Post-Condition: Gets the start and end position and calls upon all of the movement functions
     */
    private class ClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //store the clicked position in the grid
            int clickedRow = -1;
            int clickedCol = -1;

            //determine which button got clicked
            JButton but = (JButton) e.getSource();

            //find the location of the button on the grid
            for (int i = 0; i < 8; i++) { //for each row
                if (clickedRow > -1) {
                    break;
                }

                for (int j = 0; j < 8; j++) { //for each column
                    if (but.getName().equals(buttons[i][j].getName())) {
                        clickedRow = i;
                        clickedCol = j;
                        break; //done we found our square!
                    }
                }
            }

            //now call the function
            if (firstClick == false) //set it as the first position
            {
                if (whiteMove == true) {
                    firstClick = true;
                    xPos = clickedCol; //tracks the position of the piece
                    yPos = clickedRow;
                    location1 = but.getName();
                    whiteMove = false;
                    if (chessBoard[clickedRow][clickedCol] == 3) { //3 means it is a white bishop
                        pieceName = "bishop";
                        pieceColour = "white";
                    } else if (chessBoard[clickedRow][clickedCol] == 4) { //4 means it is a white knight
                        pieceName = "knight";
                        pieceColour = "white";
                    } else if (chessBoard[clickedRow][clickedCol] == 5) { //5 means it is a white rook
                        pieceName = "rook";
                        pieceColour = "white";
                    } else if (chessBoard[clickedRow][clickedCol] == 1) { //1 means it is a white pawn
                        pieceName = "pawn";
                        pieceColour = "white";
                    } else if (chessBoard[clickedRow][clickedCol] == 101) { //101 means it is a white king
                        pieceName = "king";
                        pieceColour = "white";
                    } else if (chessBoard[clickedRow][clickedCol] == 100) { //100 means it is a white queen
                        pieceName = "queen";
                        pieceColour = "white";
                    } else if (chessBoard[clickedRow][clickedCol] < 0) { //if they click on black when its white's turn output a message
                        JOptionPane.showMessageDialog(null, "It is white's turn");
                        firstClick = false;
                        whiteMove = true;
                    } else if (chessBoard[clickedRow][clickedCol] == 0) { //if they click on a blank piece output a message
                        JOptionPane.showMessageDialog(null, "That is not a valid piece");
                        firstClick = false;
                        whiteMove = true;
                    }
                } else if (whiteMove == false) { //if its black's turn
                    firstClick = true;
                    xPos = clickedCol; //tracks the position of the piece
                    yPos = clickedRow;
                    location1 = but.getName();
                    whiteMove = true;
                    if (chessBoard[clickedRow][clickedCol] == -3) { //-3 means it is a black bishop
                        pieceName = "bishop";
                        pieceColour = "black";
                    } else if (chessBoard[clickedRow][clickedCol] == -4) { //-4 means it is a black knight
                        pieceName = "knight";
                        pieceColour = "black";
                    } else if (chessBoard[clickedRow][clickedCol] == -5) { //-5 means it is a black rook
                        pieceName = "rook";
                        pieceColour = "black";
                    } else if (chessBoard[clickedRow][clickedCol] == -1) { //-1 means it is a black pawn
                        pieceName = "pawn";
                        pieceColour = "black";
                    } else if (chessBoard[clickedRow][clickedCol] == -101) { //-101 means it is a black king
                        pieceName = "king";
                        pieceColour = "black";
                    } else if (chessBoard[clickedRow][clickedCol] == -100) { //-100 means it is a black queen
                        pieceName = "queen";
                        pieceColour = "black";
                    } else if (chessBoard[clickedRow][clickedCol] > 0) { //if they click on a white piece output a message
                        JOptionPane.showMessageDialog(null, "It is black's turn");
                        firstClick = false;
                        whiteMove = false;
                    } else if (chessBoard[clickedRow][clickedCol] == 0) { //if they click on a blank tile output a message
                        JOptionPane.showMessageDialog(null, "That is not a valid piece");
                        firstClick = false;
                        whiteMove = false;
                    }
                }
            } else if (firstClick == true) //set it as the second position
            {
                firstClick = false; //resets the variables

                newXPos = clickedCol;
                newYPos = clickedRow;
                location2 = but.getName(); //gets the button name of the second location
                if (pieceName == "bishop") { //if the piece being moved is a bishop
                    bishopMovement(xPos, yPos, newXPos, newYPos, chessBoard, false, false, false, false);
                } else if (pieceName == "knight") { //if the piece being moved is a knight
                    knightMovement(xPos, yPos, newXPos, newYPos, chessBoard, false);
                } else if (pieceName == "rook") { //if the piece being moved is a rook
                    rookMovement(xPos, yPos, newXPos, newYPos, chessBoard, false, false, false);
                } else if (pieceName == "queen") { //if the piece being moved is a queen
                    queenMovement(xPos, yPos, newXPos, newYPos, chessBoard, true, false);
                } else if (pieceName == "pawn") { //if the piece being moved is a pawn
                    pawnMovement(xPos, yPos, newXPos, newYPos, chessBoard, false);
                } else if (pieceName == "king") { //if the piece being moved is a king
                    kingMovement(xPos, yPos, newXPos, newYPos, chessBoard, false);
                }

                boolean isCheck = false;

                //checks for check
                postMoveCheckTest = true;
                if (whiteMove == true) { //if black has just gone
                    pieceColour = "white";
                    for (int k = 0; k < 8; k++) { //loops through the array
                        for (int l = 0; l < 8; l++) {
                            if (chessBoard[k][l] == 101) {
                                isCheck = kingCheck(0, 0, l, k, chessBoard); //checks for check
                            }
                        }
                    }
                } else {
                    pieceColour = "black";
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (chessBoard[k][l] == -101) {
                                isCheck = kingCheck(0, 0, l, k, chessBoard);
                            }
                        }
                    }
                }
                postMoveCheckTest = false;

                if (isCheck == true) { //if it is in check it tests for checkmate
                    if (pieceColour == "white") {
                        whiteCheckCounter++;
                        //have to check for checkmate here
                        if (isNextMoveCheckMate(true, chessBoard) == true) { //if the function returns true they're in checkmate
                            JOptionPane.showMessageDialog(null, "Check Mate!");
                            gameOver("white");
                        }

                    } else {
                        blackCheckCounter++;
                        if (isNextMoveCheckMate(false, chessBoard) == true) {
                            JOptionPane.showMessageDialog(null, "Check Mate!");
                            gameOver("black");
                        }
                    }
                } else {
                    if (pieceColour == "white") { //if its no longer in check it resets the counter
                        whiteCheckCounter = 0;
                    } else {
                        blackCheckCounter = 0;
                    }
                }
                pieceName = null; //resets the variables
                pieceColour = null;

                if (whiteMove == true) { //counts and displays the moves taken
                    blackMoveCounter++;
                    BlackMovesLabel.setText("Black Moves: " + blackMoveCounter);
                } else if (whiteMove == false) {
                    whiteMoveCounter++;
                    WhiteMovesLabel.setText("White Moves: " + whiteMoveCounter);
                }

                int whiteCounter = 0; //calculates the number of pieces lost by looping through the board and subtracting the remaining pieces from 16
                int blackCounter = 0;
                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 8; b++) { //loops through the board
                        if (chessBoard[a][b] > 0) {
                            whiteCounter++;
                        } else if (chessBoard[a][b] < 0) {
                            blackCounter++;
                        }
                    }
                }
                WhitePiecesTakenLabel.setText("White Pieces Lost: " + (16 - whiteCounter)); //outputs the pieces lost
                BlackPiecesTakenLabel.setText("Black Pieces Lost: " + (16 - blackCounter));
            }
        }

    }

    /*
        Pre-Condition: Activates when a king is in check. Takes the white move boolean and chessBoard array
        Post-Condition: Checks if either black or white is in checkmate
     */
    public boolean isNextMoveCheckMate(boolean whiteMove, int[][] chessBoard) {
        boolean isCheckTrue = false;
        if (whiteMove == false) { //checks for checkmate for black
            postMoveCheckTest = true;
            for (int i = 0; i < 8; i++) { //loops through the array to find the king
                for (int j = 0; j < 8; j++) {
                    if (chessBoard[i][j] == -101) { //once it finds the king it checks if its in check
                        isCheck = kingCheck(0, 0, j, i, chessBoard);
                        postMoveCheckTest = false;
                        if (isCheck == true) {
                            isCheckTrue = true;
                            if (j > 0 && j < 7) { //the code below checks to see if the king can move to an adjacent tile. In each if statement it checks if the tile adjacent to the king is either empty or if the king can move there without entering check
                                if (i > 0 && i < 7) {
                                    if (!((chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] < 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] < 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true) && (chessBoard[i - 1][j + 1] < 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true) && (chessBoard[i + 1][j - 1] < 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true) && (chessBoard[i - 1][j - 1] < 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false; //if the king can move there return false because it is not checkmate
                                    }
                                } else if (i == 7) {
                                    if (!((chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i - 1][j + 1] < 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true) && (chessBoard[i - 1][j - 1] < 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 0) {
                                    if (!((chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] < 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] < 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true) && (chessBoard[i + 1][j - 1] < 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                }
                            } else if (j == 0) {
                                if (i > 0 && i < 7) {
                                    if (!((chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i + 1][j] < 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] < 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true) && (chessBoard[i - 1][j + 1] < 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 7) {
                                    if (!((chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i - 1][j + 1] < 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 0) {
                                    if (!((chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i + 1][j] < 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] < 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true))) {
                                        return false;
                                    }
                                }
                            } else if (j == 7) {
                                if (i > 0 && i < 7) {
                                    if (!((chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] < 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i + 1][j - 1] < 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true) && (chessBoard[i - 1][j - 1] < 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 7) {
                                    if (!((chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i - 1][j - 1] < 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 0) {
                                    if (!((chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] < 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i + 1][j - 1] < 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                }
                            }

                        } else {
                            return false; //if the king is not in check return false as that means it can't be in checkmate
                        }
                    }
                }
            }

            //here I check if any of blacks pieces can take the piece that is putting the king in check
            //or if any can get in the way
            for (int m = 0; m < 8; m++) { //loops through the board
                for (int n = 0; n < 8; n++) {
                    if (chessBoard[m][n] == -1) { //checks to see if any of its pieces can take the piece putting the black king in check
                        if (pawnMovement(n, m, checkXPos, checkYPos, chessBoard, true) == true) { //if they can take it then it is not checkmate
                            return false;
                        }
                    } else if (chessBoard[m][n] == -4) {
                        if (knightMovement(n, m, checkXPos, checkYPos, chessBoard, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == -3) {
                        if (bishopMovement(n, m, checkXPos, checkYPos, chessBoard, false, false, true, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == -5) {
                        if (rookMovement(n, m, checkXPos, checkYPos, chessBoard, false, false, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == -100) {
                        if (queenMovement(n, m, checkXPos, checkYPos, chessBoard, true, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == -101) {
                        if (kingMovement(n, m, checkXPos, checkYPos, chessBoard, true) == true) {
                            return false;
                        }
                    }
                }
            }
        } else if (whiteMove == true) { //checks for checkmate for white
            postMoveCheckTest = true;
            for (int i = 0; i < 8; i++) { //loops through the array to find the king
                for (int j = 0; j < 8; j++) {
                    if (chessBoard[i][j] == 101) { //once it finds the king it checks if its in check
                        isCheck = kingCheck(0, 0, j, i, chessBoard);
                        postMoveCheckTest = false;
                        if (isCheck == true) {
                            isCheckTrue = true;
                            if (j > 0 && j < 7) { //the code below checks to see if the king can move to an adjacent tile. In each if statement it checks if the tile adjacent to the king is either empty or if the king can move there without entering check
                                if (i > 0 && i < 7) {
                                    if (!((chessBoard[i][j + 1] > 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i][j - 1] > 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] > 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i - 1][j] > 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] > 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true) && (chessBoard[i - 1][j + 1] > 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true) && (chessBoard[i + 1][j - 1] > 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true) && (chessBoard[i - 1][j - 1] > 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false; //if the king can move there return false because it is not checkmate
                                    }
                                } else if (i == 7) {
                                    /*if (!(chessBoard[i][j + 1] < 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true)) {
                                        if (!(chessBoard[i][j - 1] < 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true)) {
                                            if (!(chessBoard[i - 1][j] < 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true)) {
                                                if (!(chessBoard[i - 1][j + 1] < 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true)) {
                                                    if (!(chessBoard[i - 1][j - 1] < 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true)) {

                                                    }
                                                }
                                            }
                                        }
                                    }*/
                                    if (!((chessBoard[i][j + 1] > 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i][j - 1] > 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i - 1][j] > 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i - 1][j + 1] > 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true) && (chessBoard[i - 1][j - 1] > 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 0) {
                                    if (!((chessBoard[i][j + 1] > 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i][j - 1] > 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] > 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] > 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true) && (chessBoard[i + 1][j - 1] > 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                }
                            } else if (j == 0) {
                                if (i > 0 && i < 7) {
                                    if (!((chessBoard[i][j + 1] > 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i + 1][j] > 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i - 1][j] > 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] > 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true) && (chessBoard[i - 1][j + 1] > 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 7) {
                                    if (!((chessBoard[i][j + 1] > 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i - 1][j] > 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i - 1][j + 1] > 0 || kingCheck(0, 0, i - 1, j + 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 0) {
                                    if (!((chessBoard[i][j + 1] > 0 || kingCheck(0, 0, i, j + 1, chessBoard) == true) && (chessBoard[i + 1][j] > 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i + 1][j + 1] > 0 || kingCheck(0, 0, i + 1, j + 1, chessBoard) == true))) {
                                        return false;
                                    }
                                }
                            } else if (j == 7) {
                                if (i > 0 && i < 7) {
                                    if (!((chessBoard[i][j - 1] > 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] > 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i - 1][j] > 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i + 1][j - 1] > 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true) && (chessBoard[i - 1][j - 1] > 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 7) {
                                    if (!((chessBoard[i][j - 1] > 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i - 1][j] > 0 || kingCheck(0, 0, i - 1, j, chessBoard) == true) && (chessBoard[i - 1][j - 1] > 0 || kingCheck(0, 0, i - 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                } else if (i == 0) {
                                    if (!((chessBoard[i][j - 1] > 0 || kingCheck(0, 0, i, j - 1, chessBoard) == true) && (chessBoard[i + 1][j] > 0 || kingCheck(0, 0, i + 1, j, chessBoard) == true) && (chessBoard[i + 1][j - 1] > 0 || kingCheck(0, 0, i + 1, j - 1, chessBoard) == true))) {
                                        return false;
                                    }
                                }
                            }

                        } else {
                            return false; //if the king is not in check return false as that means it can't be in checkmate
                        }
                    }
                }
            }

            //here I check if any of white pieces can take the piece that is putting the king in check
            //or if any can get in the way
            for (int m = 0; m < 8; m++) { //loops through the board
                for (int n = 0; n < 8; n++) {
                    if (chessBoard[m][n] == 1) { //checks to see if any of its pieces can take the piece putting the white king in check
                        if (pawnMovement(n, m, checkXPos, checkYPos, chessBoard, true) == true) { //if they can take it then it is not checkmate
                            return false;
                        }
                    } else if (chessBoard[m][n] == 4) {
                        if (knightMovement(n, m, checkXPos, checkYPos, chessBoard, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == 3) {
                        if (bishopMovement(n, m, checkXPos, checkYPos, chessBoard, false, false, true, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == 5) {
                        if (rookMovement(n, m, checkXPos, checkYPos, chessBoard, false, false, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == 100) {
                        if (queenMovement(n, m, checkXPos, checkYPos, chessBoard, true, true) == true) {
                            return false;
                        }
                    } else if (chessBoard[m][n] == 101) {
                        if (kingMovement(n, m, checkXPos, checkYPos, chessBoard, true) == true) {
                            return false;
                        }
                    }
                }
            }
        }

        if (isCheckTrue == true) { //returns true or false depending if it is in check or has met any of the conditions above
            return true;
        } else {
            return false;
        }
    }

    /*
        Pre-Condition: Activates when a player is in checkmate. Takes the pieceColour
        Post-Condition: Calculates the user score and writes the user's information on an xml document
     */
    public void gameOver(String pieceColour) {
        long finish = System.currentTimeMillis(); //stores the final time
        long timeTaken = finish - start; //calculates the total time taken
        long playerScore = 3600 - (timeTaken / 1000); //the subtraction of 10,000 is an arbitrary value to keep the scores relatively low as to not break any limits of the data types
        if ((timeTaken / 1000) > 3600) {
            playerScore = 10;
        }
        long calculate = 100; //the code below loops through the chess board and calculates a score based on how many of the oponents pieces are left
        if (pieceColour == "white") {
            for (int i = 0; i < 8; i++) { //loops through the array
                for (int j = 0; j < 8; j++) {
                    //instead of tracking when each piece was taken, I have taken the approach of deducting the pieces remaining from 100
                    if (chessBoard[i][j] == -1) { //a pawn has a score of 1
                        calculate--;
                    } else if (chessBoard[i][j] == -3) { //a knight and a bishop have a score of 3
                        calculate = calculate - 3;
                    } else if (chessBoard[i][j] == -4) {
                        calculate = calculate - 3;
                    } else if (chessBoard[i][j] == -5) { //a rook has a score of 5
                        calculate = calculate - 5;
                    } else if (chessBoard[i][j] == -100) { //a queen has a score of 10
                        calculate = calculate - 10;
                    }
                }
            }
        } else if (pieceColour == "black") { //same code as above for the score calculation
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessBoard[i][j] == 1) {
                        calculate--;
                    } else if (chessBoard[i][j] == 3) {
                        calculate = calculate - 3;
                    } else if (chessBoard[i][j] == 4) {
                        calculate = calculate - 3;
                    } else if (chessBoard[i][j] == 5) {
                        calculate = calculate - 5;
                    } else if (chessBoard[i][j] == 100) {
                        calculate = calculate - 10;
                    }
                }
            }
        }
        playerScore = playerScore + calculate; //calculates the final score by adding the time and the pieces remaining scores
        //creates a dialog box that asks for the players name to submit as a high score
        String s = (String) JOptionPane.showInputDialog(null, "Enter your name:", "High Score Name", JOptionPane.PLAIN_MESSAGE, null, null, null);
        String playerName = s;

        if (playerName == null) {
            playerName = "player1";
        }

        OutputStream fout = null;
        OutputStream bout = null;
        OutputStreamWriter out = null;
        try { //try and catch handles any errors that may occur
            String filepath = "highscores.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            //Get the highscores element so we can create a new highscore inside it
            Node highscores = doc.getElementsByTagName("highscores").item(0);

            //create a new highscore element to store all the data
            Element highscore = doc.createElement("highscore");
            Element name = doc.createElement("name");
            name.setTextContent(playerName);
            highscore.appendChild(name);
            Element score = doc.createElement("score");
            score.setTextContent("" + playerScore);
            highscore.appendChild(score);
            Element time = doc.createElement("time");
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time.setTextContent("" + sdf.format(cal.getTime()));
            highscore.appendChild(time);

            //now add the completed new highscore element to the highscores list
            highscores.appendChild(highscore);

            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } finally {
            try { //closes the file
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {
            }
            try {
                if (bout != null) {
                    bout.close();
                }
            } catch (Exception e) {
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
            }
        }

        this.setVisible(false);
        new Chess().setVisible(true); //switches between jframes
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MultiplayerChess.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiplayerChess.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiplayerChess.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiplayerChess.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and displaWhiteTile1rm */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiplayerChess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlackMovesLabel;
    private javax.swing.JLabel BlackPiecesTakenLabel;
    private javax.swing.JLabel BlackStatsLabel;
    private javax.swing.JButton Tile1;
    private javax.swing.JButton Tile10;
    private javax.swing.JButton Tile11;
    private javax.swing.JButton Tile12;
    private javax.swing.JButton Tile13;
    private javax.swing.JButton Tile14;
    private javax.swing.JButton Tile15;
    private javax.swing.JButton Tile16;
    private javax.swing.JButton Tile17;
    private javax.swing.JButton Tile18;
    private javax.swing.JButton Tile19;
    private javax.swing.JButton Tile2;
    private javax.swing.JButton Tile20;
    private javax.swing.JButton Tile21;
    private javax.swing.JButton Tile22;
    private javax.swing.JButton Tile23;
    private javax.swing.JButton Tile24;
    private javax.swing.JButton Tile25;
    private javax.swing.JButton Tile26;
    private javax.swing.JButton Tile27;
    private javax.swing.JButton Tile28;
    private javax.swing.JButton Tile29;
    private javax.swing.JButton Tile3;
    private javax.swing.JButton Tile30;
    private javax.swing.JButton Tile31;
    private javax.swing.JButton Tile32;
    private javax.swing.JButton Tile33;
    private javax.swing.JButton Tile34;
    private javax.swing.JButton Tile35;
    private javax.swing.JButton Tile36;
    private javax.swing.JButton Tile37;
    private javax.swing.JButton Tile38;
    private javax.swing.JButton Tile39;
    private javax.swing.JButton Tile4;
    private javax.swing.JButton Tile40;
    private javax.swing.JButton Tile41;
    private javax.swing.JButton Tile42;
    private javax.swing.JButton Tile43;
    private javax.swing.JButton Tile44;
    private javax.swing.JButton Tile45;
    private javax.swing.JButton Tile46;
    private javax.swing.JButton Tile47;
    private javax.swing.JButton Tile48;
    private javax.swing.JButton Tile49;
    private javax.swing.JButton Tile5;
    private javax.swing.JButton Tile50;
    private javax.swing.JButton Tile51;
    private javax.swing.JButton Tile52;
    private javax.swing.JButton Tile53;
    private javax.swing.JButton Tile54;
    private javax.swing.JButton Tile55;
    private javax.swing.JButton Tile56;
    private javax.swing.JButton Tile57;
    private javax.swing.JButton Tile58;
    private javax.swing.JButton Tile59;
    private javax.swing.JButton Tile6;
    private javax.swing.JButton Tile60;
    private javax.swing.JButton Tile61;
    private javax.swing.JButton Tile62;
    private javax.swing.JButton Tile63;
    private javax.swing.JButton Tile64;
    private javax.swing.JButton Tile7;
    private javax.swing.JButton Tile8;
    private javax.swing.JButton Tile9;
    private javax.swing.JLabel WhiteMovesLabel;
    private javax.swing.JLabel WhitePiecesTakenLabel;
    private javax.swing.JLabel WhiteStatsLabel;
    // End of variables declaration//GEN-END:variables
}
