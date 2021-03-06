package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.Cursor;
import Controllers.Controller;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class HomeBuilder extends JFrame {

	private Controller viewCtrl;
	private JPanel contentPane;
	private int mouseX;
	private int mouseY;
	
	public HomePanel homePanel;
	public FleetPanel fleetPanel;
	public FlightBoardPanel flightBoardPanel;
	public MapControllerPanel mapPanel;
		
	
	public HomeBuilder(Controller ctrl) {
		
		viewCtrl = ctrl;
		
		Image exitIcon = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();

		
		setResizable(false);
		setTitle("AirPlan");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Viewpanel = new JPanel();
		Viewpanel.setBounds(236, 0, 1044, 681);
		contentPane.add(Viewpanel);
		Viewpanel.setLayout(new CardLayout(0, 0));

		homePanel = new HomePanel();
		fleetPanel = new FleetPanel(viewCtrl);
		flightBoardPanel = new FlightBoardPanel(viewCtrl);
		mapPanel = new MapControllerPanel(viewCtrl);

		/* Adding buttons to the panel */
		Viewpanel.add(homePanel, "name_78750354984400");
		Viewpanel.add(fleetPanel, "name_78750381602200");
		Viewpanel.add(flightBoardPanel, "name_78750403585200");
		Viewpanel.add(mapPanel);

		
		MenuClicked(homePanel);
		
		JPanel NavBar = new JPanel();
		NavBar.setBackground(new Color(37,104,162));
		NavBar.setBounds(0, 0, 236, 680);
		contentPane.add(NavBar);
		NavBar.setLayout(null);
		
		JLabel moveLbl = new JLabel("");
		moveLbl.setBounds(40, 0, 196, 30);
		NavBar.add(moveLbl);
		
		JLabel exitBtn = new JLabel("");
		exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitBtn.setBounds(5, 5, 25, 25);
		exitBtn.setIcon(new ImageIcon(exitIcon));
		NavBar.add(exitBtn);
		
		JPanel HomeBtn = new JPanel();
		HomeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		HomeBtn.setBackground(new Color(37,104,162));
		HomeBtn.setBounds(0, 102, 236, 59);
		NavBar.add(HomeBtn);
		HomeBtn.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setBounds(50, 11, 55, 37);
		HomeBtn.add(lblNewLabel);
		
		JPanel AircraftFleetBtn = new JPanel();
		AircraftFleetBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AircraftFleetBtn.setLayout(null);
		AircraftFleetBtn.setBackground(new Color(37,104,162));
		AircraftFleetBtn.setBounds(0, 172, 236, 59);
		NavBar.add(AircraftFleetBtn);
		
		JLabel lblAircraftFleet = new JLabel("Planes Fleet");
		lblAircraftFleet.setForeground(Color.WHITE);
		lblAircraftFleet.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblAircraftFleet.setBounds(50, 11, 145, 37);
		AircraftFleetBtn.add(lblAircraftFleet);
		
		JPanel FlightScheduleBtn = new JPanel();
		FlightScheduleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FlightScheduleBtn.setLayout(null);
		FlightScheduleBtn.setBackground(new Color(37,104,162));
		FlightScheduleBtn.setBounds(0, 242, 236, 59);
		NavBar.add(FlightScheduleBtn);
		
		JLabel lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setForeground(Color.WHITE);
		lblFlightBoard.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblFlightBoard.setBounds(50, 11, 132, 37);
		FlightScheduleBtn.add(lblFlightBoard);
		
		JPanel MapControllerBtn = new JPanel();
		MapControllerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MapControllerBtn.setLayout(null);
		MapControllerBtn.setBackground(new Color(37,104,162));
		MapControllerBtn.setBounds(0, 312, 236, 59);
		NavBar.add(MapControllerBtn);
		
		JLabel lblMapController = new JLabel("Map View");
		lblMapController.setForeground(Color.WHITE);
		lblMapController.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblMapController.setBounds(50, 11, 132, 37);
		MapControllerBtn.add(lblMapController);
		
			
			//Overrides
			HomeBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					HomeBtn.setBackground(new Color(51, 153, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					HomeBtn.setBackground(new Color(37,104,162));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuClicked(homePanel);
				}
			});
			
			AircraftFleetBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					AircraftFleetBtn.setBackground(new Color(102, 178, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					AircraftFleetBtn.setBackground(new Color(37,104,162));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuClicked(fleetPanel);
				}
			});
			
			FlightScheduleBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					FlightScheduleBtn.setBackground(new Color(153, 204, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					FlightScheduleBtn.setBackground(new Color(37,104,162));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuClicked(flightBoardPanel);
					flightBoardPanel.getScrollPane().setVisible(false);
					flightBoardPanel.buildFleetTable();
					flightBoardPanel.getFleetTable().invalidate();
					flightBoardPanel.getScrollPane().setVisible(true);
					flightBoardPanel.detailsPanel.setVisible(false);
				}
			});
			
			MapControllerBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					MapControllerBtn.setBackground(new Color(180, 200, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					MapControllerBtn.setBackground(new Color(37,104,162));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuClicked(mapPanel);
				}
			});
			exitBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			
			moveLbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mouseX = e.getX();
					mouseY = e.getY();
				}
			});
			moveLbl.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int kordinatX = e.getXOnScreen();
					int kordinatY = e.getYOnScreen();
					
					setLocation(kordinatX - mouseX, kordinatY - mouseY);
				}
			});
	}
	
	/* A function to set all the panels FALSE except for the panel we currently pressed */
	public void MenuClicked(JPanel panel) {
				homePanel.setVisible(false);
				fleetPanel.setVisible(false);
				flightBoardPanel.setVisible(false);
				mapPanel.setVisible(false);
				panel.setVisible(true);
				
			}
}
