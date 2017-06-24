package com.rishabh.app;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class FrontEnd {
		private JFrame frame;
		private MyPanel panel;
		private JButton genmap;
		private int height=500;
		private int width=500;
		private ArrayList<Node> nodes=new ArrayList<Node>();
		private JPanel bottomPanel;
		private JCheckBox showLines;
		public class Node
		{
			int xcor,ycor;
			String name;
		}
		@SuppressWarnings("serial")
		public class MyPanel extends JPanel implements ActionListener,ItemListener
		{
			private int nocrand;
			private boolean show;
			private int randnoX[];
			private int randnoY[];
			private int temprand;
			private int temprand2;
			public void init()
			{
				nocrand=(int)(Math.random()*21)+1;
				randnoX=new int[nocrand];
				randnoY=new int[nocrand];
				for(int i=0;i<nocrand;i++)
				{
					temprand=((int)(Math.random()*9)+1);
					temprand2=((int)(Math.random()*9)+1);
					if(!(search(randnoX,temprand) && search(randnoY,temprand2)))
					{
						nodes.add(i,new Node());
						nodes.get(i).xcor=temprand;
						nodes.get(i).ycor=temprand2;
						nodes.get(i).name="A"+i;
						randnoX[i]=temprand;
						randnoY[i]=temprand2;
					}
					else
						i--;
					System.out.println(temprand+" , "+temprand2 + " , " +i);
				}
				
			}
			
			private boolean search(int[] randno2, int temprand22) {
				Arrays.sort(randno2);
				if(Arrays.binarySearch(randno2, temprand22)>=0)
				return true;
				return false;
			}

			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				if(show==true)
				{
					for(int i=0;i<9;i++)
					{
						g.drawLine(0,(i+1)*(getHeight()/10), getWidth(), (i+1)*(getHeight()/10));
						g.drawLine((i+1)*(getWidth()/10),0, (i+1)*(getWidth()/10),getHeight());
					}
					g.drawLine(0,10*(getHeight()/10), getWidth(), 10*(getHeight()/10));
				}
				for(int i=0;i<nocrand;i++)
				{
					g.drawOval((nodes.get(i).xcor*(getWidth()/10))-(getWidth()/40),(nodes.get(i).ycor*(getHeight()/10))-(getHeight()/40), (getWidth()/20), (getHeight()/20));
					g.drawString(nodes.get(i).name, (nodes.get(i).xcor*(getWidth()/10))-(getWidth()/80), (nodes.get(i).ycor*(getHeight()/10))+(getHeight()/80));
				}
			}
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panel.init();
				repaint();
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox jc=(JCheckBox) e.getSource();
				if(jc.isSelected())
				{
					show=true;
				}
				else
					show=false;
				repaint();
				
			}
		}
		public FrontEnd()
		{
			frame=new JFrame("Map");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(height, width);
			panel=new MyPanel();
			panel.init();
			frame.add(panel,BorderLayout.CENTER);
			bottomPanel=new JPanel();
			frame.setVisible(true);
			
			genmap=new JButton("New Map");
			genmap.addActionListener(panel);
			bottomPanel.add(genmap);
			showLines=new JCheckBox("show lines");
			showLines.addItemListener(panel);
			bottomPanel.add(showLines);
			frame.add(bottomPanel,BorderLayout.SOUTH);
		}

		
}
