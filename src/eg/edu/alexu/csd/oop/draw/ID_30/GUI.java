package eg.edu.alexu.csd.oop.draw.ID_30;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.circle;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.ellipse;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.line;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.rectangle;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.square;
import eg.edu.alexu.csd.oop.draw.ID_30.basicShapes.triangle;

import javax.swing.UIManager;

public class GUI extends JFrame {

    private Timer refresher;

    String clicked = "";
    JButton btnColor = new JButton("COLOR");
    JButton btnFillColor = new JButton("FILL COLOR");
    JButton btnMove = new JButton("MOVE");
    JButton btnResize = new JButton("RESIZE");
    JButton btnDelete = new JButton("DELETE");
    JButton btnSelect = new JButton("SELECT");
    JButton btnR_Rectangle = new JButton("R_RECTANGLE");

    Color prevColor;
    Shape selectedShape;
    String selected = null;
    int oldX, oldY, newX, newY;

    public GUI() {

        setResizable(false);
        setTitle("DRAW");
        setSize(1000, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBounds(164, 10, 776, 750);
        getContentPane().add(panel);
        DrawingEngine engine = new DrawingEngineImp();
        JButton btnLine = new JButton("LINE");
        btnLine.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y2;
            boolean firstClick = true;

            @Override
            public void mouseClicked(MouseEvent e1) {
                if (clicked == "SELECT" && btnSelect.getText() != "OK")
                    selectedShape.setColor(prevColor);
                btnLine.setEnabled(false);
                panel.removeMouseListener(this);
                clicked = "LINE";
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent el) {
                        if (firstClick) {
                            x1 = el.getX();
                            y1 = el.getY();
                            firstClick = false;
                        } else {
                            x2 = el.getX();
                            y2 = el.getY();
                            panel.removeMouseListener(this);
                            if (clicked == "LINE") {
                                line newShape = new line(x1, y1, x2, y2);
                                engine.addShape(newShape);
                                panel.paint(panel.getGraphics());
                                engine.refresh(panel.getGraphics());


                            }
                            btnLine.setEnabled(true);
                            firstClick = true;
                        }
                    }
                });
            }
        });

        btnLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnLine.setBounds(10, 10, 144, 21);
        getContentPane().add(btnLine);

        JButton btnSquare = new JButton("SQUARE");
        btnSquare.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y2;
            boolean firstClick = true;

            @Override
            public void mouseClicked(MouseEvent e2) {
                if (clicked == "SELECT" && btnSelect.getText() != "OK")
                    selectedShape.setColor(prevColor);
                btnSquare.setEnabled(false);
                panel.removeMouseListener(this);
                clicked = "SQUARE";
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent es) {
                        if (firstClick) {
                            x1 = es.getX();
                            y1 = es.getY();
                            firstClick = false;
                        } else {
                            x2 = es.getX();
                            y2 = es.getY();
                            panel.removeMouseListener(this);
                            if (clicked == "SQUARE") {
                                square newShape = new square(x1, y1, Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)));
                                engine.addShape(newShape);
                                panel.paint(panel.getGraphics());
                                engine.refresh(panel.getGraphics());
                            }
                            btnSquare.setEnabled(true);
                            firstClick = true;
                        }
                    }
                });
            }
        });
        btnSquare.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSquare.setBounds(10, 41, 144, 21);
        getContentPane().add(btnSquare);

        JButton btnRectangle = new JButton("RECTANGLE");
        btnRectangle.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y2;
            boolean firstClick = true;

            @Override
            public void mouseClicked(MouseEvent e3) {
                if (clicked == "SELECT" && btnSelect.getText() != "OK")
                    selectedShape.setColor(prevColor);
                btnRectangle.setEnabled(false);
                panel.removeMouseListener(this);
                clicked = "RECTANGLE";
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent er) {
                        if (firstClick) {
                            x1 = er.getX();
                            y1 = er.getY();
                            firstClick = false;
                        } else {
                            x2 = er.getX();
                            y2 = er.getY();
                            panel.removeMouseListener(this);
                            if (clicked == "RECTANGLE") {
                                rectangle newShape = new rectangle(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
                                engine.addShape(newShape);
                                panel.paint(panel.getGraphics());
                                engine.refresh(panel.getGraphics());
                            }
                            btnRectangle.setEnabled(true);
                            firstClick = true;
                        }
                    }
                });
            }
        });
        btnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRectangle.setBounds(10, 72, 144, 21);
        getContentPane().add(btnRectangle);

        JButton btnTriangle = new JButton("TRIANGLE");
        btnTriangle.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y2, x3, y3;
            boolean firstClick = true;
            boolean secondClick = false;

            @Override
            public void mouseClicked(MouseEvent e4) {
                if (clicked == "SELECT" && btnSelect.getText() != "OK")
                    selectedShape.setColor(prevColor);
                btnTriangle.setEnabled(false);
                panel.removeMouseListener(this);
                clicked = "TRIANGLE";
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent et) {
                        if (firstClick) {
                            x1 = et.getX();
                            y1 = et.getY();
                            firstClick = false;
                            secondClick = true;
                        } else if (secondClick) {
                            x2 = et.getX();
                            y2 = et.getY();
                            secondClick = false;
                            if (clicked != "TRIANGLE") {
                                btnTriangle.setEnabled(true);
                                firstClick = true;
                                panel.removeMouseListener(this);
                                return;
                            }
                        } else {
                            x3 = et.getX();
                            y3 = et.getY();
                            if (clicked == "TRIANGLE") {
                                triangle newShape = new triangle(x1, y1, x2, y2, x3, y3);
                                engine.addShape(newShape);
                                panel.paint(panel.getGraphics());
                                engine.refresh(panel.getGraphics());
                            }
                            btnTriangle.setEnabled(true);
                            firstClick = true;
                            panel.removeMouseListener(this);
                        }
                    }
                });
            }
        });
        btnTriangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnTriangle.setBounds(10, 103, 144, 21);
        getContentPane().add(btnTriangle);

        JButton btnCircle = new JButton("CIRCLE");
        btnCircle.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y2;
            boolean firstClick = true;

            @Override
            public void mouseClicked(MouseEvent e5) {
                if (clicked == "SELECT" && btnSelect.getText() != "OK")
                    selectedShape.setColor(prevColor);
                btnCircle.setEnabled(false);
                panel.removeMouseListener(this);
                clicked = "CIRCLE";
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent ec) {
                        if (firstClick) {
                            x1 = ec.getX();
                            y1 = ec.getY();
                            firstClick = false;
                        } else {
                            x2 = ec.getX();
                            y2 = ec.getY();
                            panel.removeMouseListener(this);
                            if (clicked == "CIRCLE") {
                                circle newShape = new circle(x1, y1,
                                        Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
                                engine.addShape(newShape);
                                panel.paint(panel.getGraphics());
                                engine.refresh(panel.getGraphics());
                            }
                            btnCircle.setEnabled(true);
                            firstClick = true;
                        }
                    }
                });
            }
        });
        btnCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCircle.setBounds(10, 134, 144, 21);
        getContentPane().add(btnCircle);

        JButton btnEllipse = new JButton("ELLIPSE");
        btnEllipse.addMouseListener(new MouseAdapter() {
            int x1, y1, x2, y3;
            String Click = "first";

            @Override
            public void mouseClicked(MouseEvent e6) {
                if (clicked == "SELECT" && btnSelect.getText() != "OK")
                    selectedShape.setColor(prevColor);
                btnEllipse.setEnabled(false);
                panel.removeMouseListener(this);
                clicked = "ELLIPSE";
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent ee) {
                        if (Click == "first") {
                            x1 = ee.getX();
                            y1 = ee.getY();
                            Click = "second";
                        } else if (Click == "second") {
                            x2 = ee.getX();
                            ee.getY();
                            Click = "third";
                            if (clicked != "ELLIPSE") {
                                btnEllipse.setEnabled(true);
                                Click = "first";
                                panel.removeMouseListener(this);
                                return;
                            }
                        } else {
                            ee.getX();
                            y3 = ee.getY();
                            if (clicked == "ELLIPSE") {
                                ellipse newShape = new ellipse(x1 - Math.abs(x1 - x2), y1 - Math.abs(y1 - y3),
                                        2 * Math.abs(x1 - x2), 2 * Math.abs(y1 - y3));
                                engine.addShape(newShape);
                                panel.paint(panel.getGraphics());
                                engine.refresh(panel.getGraphics());
                            }
                            btnEllipse.setEnabled(true);
                            Click = "first";
                            panel.removeMouseListener(this);
                        }
                    }
                });
            }
        });
        btnEllipse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEllipse.setBounds(10, 165, 144, 21);
        getContentPane().add(btnEllipse);

        btnSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e7) {
                clicked = "SELECT";
                if (selected == "color") {
                    Shape updatedShape = null;
                    selectedShape.setColor(prevColor);
                    try {
                        updatedShape = (Shape) selectedShape.clone();
                    } catch (CloneNotSupportedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    updatedShape.setColor(JColorChooser.showDialog(null, "choose your color", Color.black));
                    btnSelect.setText("SELECT");
                    engine.updateShape(selectedShape, updatedShape);
                    panel.paint(panel.getGraphics());
                    engine.refresh(panel.getGraphics());
                    btnColor.setEnabled(false);
                    btnFillColor.setEnabled(false);
                    btnMove.setEnabled(false);
                    btnResize.setEnabled(false);
                    btnDelete.setEnabled(false);
                    selected = null;
                    return;
                } else if (selected == "fillColor") {
                    Shape updatedShape = null;
                    selectedShape.setColor(prevColor);
                    try {
                        updatedShape = (Shape) selectedShape.clone();
                    } catch (CloneNotSupportedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    updatedShape.setFillColor(JColorChooser.showDialog(null, "choose your color", Color.black));
                    btnSelect.setText("SELECT");
                    engine.updateShape(selectedShape, updatedShape);
                    panel.paint(panel.getGraphics());
                    engine.refresh(panel.getGraphics());
                    btnColor.setEnabled(false);
                    btnFillColor.setEnabled(false);
                    btnMove.setEnabled(false);
                    btnResize.setEnabled(false);
                    btnDelete.setEnabled(false);
                    selected = null;
                    return;
                } else if (selected == "move") {
                    selectedShape.setColor(prevColor);
                    Shape updatedShape = ((ShapeImp) selectedShape).move(oldX, oldY, newX, newY);
                    engine.updateShape(selectedShape, updatedShape);
                    btnSelect.setText("SELECT");
                    panel.paint(panel.getGraphics());
                    engine.refresh(panel.getGraphics());
                    btnColor.setEnabled(false);
                    btnFillColor.setEnabled(false);
                    btnMove.setEnabled(false);
                    btnResize.setEnabled(false);
                    btnDelete.setEnabled(false);
                    selected = null;
                    return;
                } else if (selected == "reSize") {
                    selectedShape.setColor(prevColor);
                    Shape updatedShape = ((ShapeImp) selectedShape).resize(newX, newY);
                    engine.updateShape(selectedShape, updatedShape);
                    btnSelect.setText("SELECT");
                    panel.paint(panel.getGraphics());
                    engine.refresh(panel.getGraphics());
                    btnColor.setEnabled(false);
                    btnFillColor.setEnabled(false);
                    btnMove.setEnabled(false);
                    btnResize.setEnabled(false);
                    btnDelete.setEnabled(false);
                    selected = null;
                    return;
                } else if (selected == "delete") {
                    selectedShape.setColor(prevColor);
                    engine.removeShape(selectedShape);
                    btnSelect.setText("SELECT");
                    panel.paint(panel.getGraphics());
                    engine.refresh(panel.getGraphics());
                    btnColor.setEnabled(false);
                    btnFillColor.setEnabled(false);
                    btnMove.setEnabled(false);
                    btnResize.setEnabled(false);
                    btnDelete.setEnabled(false);
                    selected = null;
                    return;
                }
                clicked = "SELECT";
                btnSelect.setEnabled(false);
                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent eSelect) {
                        selectedShape = ((DrawingEngineImp) engine).select(eSelect.getX(), eSelect.getY());
                        if (selectedShape == null) {
                            btnSelect.setEnabled(true);
                            return;
                        }
                        if (clicked != "SELECT") {
                            btnSelect.setEnabled(true);
                            panel.removeMouseListener(this);
                            return;
                        }
                        btnSelect.setEnabled(true);
                        prevColor = selectedShape.getColor();
                        selectedShape.setColor(Color.blue);
                        panel.paint(panel.getGraphics());
                        engine.refresh(panel.getGraphics());
                        panel.removeMouseListener(this);
                        btnColor.setEnabled(true);
                        btnFillColor.setEnabled(true);
                        btnMove.setEnabled(true);
                        btnResize.setEnabled(true);
                        btnDelete.setEnabled(true);

                        btnColor.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e8) {
                                selected = "color";
                                btnSelect.setText("OK");
                                return;
                            }
                        });

                        btnFillColor.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e9) {
                                selected = "fillColor";
                                btnSelect.setText("OK");
                                return;
                            }
                        });

                        btnMove.addMouseListener(new MouseAdapter() {
                            boolean firstClick = true;

                            @Override
                            public void mouseClicked(MouseEvent e10) {
                                btnMove.setEnabled(false);
                                panel.addMouseListener(new MouseAdapter() {
                                    public void mouseClicked(MouseEvent eMove) {
                                        if (firstClick) {
                                            oldX = eMove.getX();
                                            oldY = eMove.getY();
                                            firstClick = false;
                                        } else {
                                            newX = eMove.getX();
                                            newY = eMove.getY();
                                            firstClick = true;
                                            panel.removeMouseListener(this);
                                            selected = "move";
                                            btnSelect.setText("OK");
                                            return;
                                        }
                                    }
                                });
                            }
                        });

                        btnResize.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e11) {
                                btnResize.setEnabled(false);
                                panel.addMouseListener(new MouseAdapter() {
                                    public void mouseClicked(MouseEvent eReSize) {
                                        newX = eReSize.getX();
                                        newY = eReSize.getY();
                                        panel.removeMouseListener(this);
                                        selected = "reSize";
                                        btnSelect.setText("OK");
                                        return;
                                    }
                                });
                            }
                        });

                        btnDelete.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                selected = "delete";
                                btnSelect.setText("OK");
                                return;
                            }
                        });
                        if (selected == "color" || selected == "fillColor" || selected == "move" || selected == "reSize" || selected == "delete")
                            btnSelect.doClick();

                    }
                });

            }
        });
        btnSelect.setForeground(UIManager.getColor("Button.foreground"));
        btnSelect.setBackground(UIManager.getColor("Button.background"));
        btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSelect.setBounds(10, 273, 144, 21);
        getContentPane().add(btnSelect);

        btnColor.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnColor.setBackground(UIManager.getColor("Button.background"));
        btnColor.setBounds(10, 304, 144, 21);
        getContentPane().add(btnColor);
        btnColor.setEnabled(false);

        btnFillColor.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnFillColor.setBounds(10, 335, 144, 21);
        getContentPane().add(btnFillColor);
        btnFillColor.setEnabled(false);

        btnMove.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnMove.setBounds(10, 366, 144, 21);
        getContentPane().add(btnMove);
        btnMove.setEnabled(false);

        btnResize.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnResize.setBounds(10, 397, 144, 21);
        getContentPane().add(btnResize);
        btnResize.setEnabled(false);

        btnDelete.setFont(new Font("Dialog", Font.PLAIN, 16));
        btnDelete.setBounds(10, 428, 144, 21);
        getContentPane().add(btnDelete);
        btnDelete.setEnabled(false);

        JButton btnUndo = new JButton("UNDO");
        btnUndo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                engine.undo();
                panel.paint(panel.getGraphics());
                engine.refresh(panel.getGraphics());
            }
        });
        btnUndo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnUndo.setBounds(10, 512, 144, 21);
        getContentPane().add(btnUndo);

        JButton btnRedo = new JButton("REDO");
        btnRedo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                engine.redo();
                panel.paint(panel.getGraphics());
                engine.refresh(panel.getGraphics());
            }
        });
        btnRedo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRedo.setBounds(10, 543, 144, 21);
        getContentPane().add(btnRedo);

        JButton btnSave = new JButton("SAVE");
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent eSave) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("xml", "json");
                fileChooser.setFileFilter(filter);
                FileNameExtensionFilter filter2 = new FileNameExtensionFilter("json", "xml");
                fileChooser.setFileFilter(filter2);
                fileChooser.setDialogTitle("Save as");
                int userSelection = fileChooser.showSaveDialog(fileChooser);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    engine.save(fileToSave.getAbsolutePath());
                }
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSave.setBounds(10, 602, 144, 21);
        getContentPane().add(btnSave);

        JButton btnLoad = new JButton("LOAD");
        btnLoad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent eLoad) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    engine.load(selectedFile.getAbsolutePath());
                    panel.paint(panel.getGraphics());
                    engine.refresh(panel.getGraphics());
                }
            }
        });
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnLoad.setBounds(10, 633, 144, 21);
        getContentPane().add(btnLoad);

        JButton btnDynamicLoad = new JButton("D_LOAD");
        btnDynamicLoad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent eD_Load) {
                btnR_Rectangle.setEnabled(true);
                btnR_Rectangle.addMouseListener(new MouseAdapter() {
                    int x1, y1, x2, y2;
                    boolean firstClick = true;

                    @Override
                    public void mouseClicked(MouseEvent e12) {
                        if (clicked == "SELECT" && btnSelect.getText() != "OK")
                            selectedShape.setColor(prevColor);
                        btnR_Rectangle.setEnabled(false);
                        panel.removeMouseListener(this);
                        clicked = "R_RECTANGLE";
                        panel.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent er) {
                                if (firstClick) {
                                    x1 = er.getX();
                                    y1 = er.getY();
                                    firstClick = false;
                                } else {
                                    x2 = er.getX();
                                    y2 = er.getY();
                                    panel.removeMouseListener(this);
                                    if (clicked == "R_RECTANGLE") {
                                        engine.addShape(((DrawingEngineImp) engine).makeRR(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1)));
                                        panel.paint(panel.getGraphics());
                                        engine.refresh(panel.getGraphics());
                                        btnR_Rectangle.setEnabled(true);
                                    }
                                    firstClick = true;
                                }
                            }
                        });
                    }
                });
            }
        });
        btnDynamicLoad.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDynamicLoad.setBounds(10, 703, 144, 21);
        getContentPane().add(btnDynamicLoad);


        btnR_Rectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnR_Rectangle.setBounds(10, 197, 144, 21);
        getContentPane().add(btnR_Rectangle);
        btnR_Rectangle.setEnabled(false);

        reloadGUI();

    }

    public void reloadGUI() {

        TimerTask reloadAll = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                repaint();
                cancel();

            }
        };

        refresher = new Timer();
        refresher.scheduleAtFixedRate(reloadAll, 10, 10);

    }

}
