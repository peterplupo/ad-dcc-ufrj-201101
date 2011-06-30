package simulator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class SimulatorView extends JFrame implements ActionListener,
		WindowListener {
	private JFrame frame;
	private JLabel startLabel;
	private JLabel statusMsg;
	private JButton startButton;
	private JPanel panelTable;
	private JPanel startPanel;
	private JPanel statusPanel;
	private JTable tableResult;
	private JScrollPane pane;
	private double ro;

	public SimulatorView() {
		super("Simulator");
		ro = 0.0;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);

		initComponents();
	}

	public void start() {
		pack();
		frame.setSize(800, 300);
		frame.setVisible(true);
	}

	private void initComponents() {

		startLabel = new JLabel("Clique para comecar a simulacao:");

		startButton = new JButton("Comecar");
		startButton.addActionListener(this);

		startPanel = new JPanel();
		startPanel.add(startLabel);
		startPanel.add(startButton);

		String cols[] = { "Metricas", "Fila 1", "+/-", "Fila 2", "+/-" };
		String lines[][] = { { "Tempo Total - E[T]", "", "", "", "" },
				{ "Tempo de Espera - E[W]", "", "", "", "" },
				{ "Numero Total - E[N]", "", "", "", "" },
				{ "Numero em Espera - E[Nq]", "", "", "", "" },
				{ "Variancia da Espera - V[W]", "", "-", "", "-" } };

		DefaultTableModel model = new DefaultTableModel(lines, cols);
		tableResult = new JTable(model);
		JTableHeader header = tableResult.getTableHeader();
		header.setBackground(Color.gray);

		pane = new JScrollPane(tableResult);

		panelTable = new JPanel();
		panelTable.add(pane);

		statusMsg = new JLabel("Aguardando inicio da execucao...");

		statusPanel = new JPanel(new BorderLayout());
		statusPanel.setBorder(new TitledBorder("Status"));
		statusPanel.add(statusMsg);

		frame = new JFrame("Simulador");
		frame.add(startPanel, BorderLayout.NORTH);
		frame.add(statusPanel, BorderLayout.CENTER);
		frame.add(panelTable);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//

		if (e.getActionCommand().equals("Comecar")) {
			SimulationManager simulationManager = new SimulationManager(0);
			MetricsAgregator metricsAgregator;

			statusMsg.setText("Iniciando teste com ro = 0.2.");
			ro+=0.2;
			simulationManager.runSimulation(ro);
			metricsAgregator = simulationManager.getMetricsAgregator();

			//fila 1
			SetData(metricsAgregator.getMeanTotal1(),0,1);
			SetData(metricsAgregator.getDeviationTotal1(),0,2);
			SetData(metricsAgregator.getMeanAtraso1(),1,1);
			SetData(metricsAgregator.getDeviationAtraso1(),1,2);
			SetData(metricsAgregator.getMeanNFila1(),2,1);
			SetData(metricsAgregator.getDeviationNTotal1(),2,2);
			SetData(metricsAgregator.getMeanNAtraso1(),3,1);
			SetData(metricsAgregator.getDeviationNAtraso1(),3,2);
			SetData(metricsAgregator.getVarianceAtraso1(),4,1);
			
			//fila 2
			SetData(metricsAgregator.getMeanTotal1(),0,3);
			SetData(metricsAgregator.getDeviationTotal2(),0,4);
			SetData(metricsAgregator.getMeanAtraso1(),1,3);
			SetData(metricsAgregator.getDeviationAtraso2(),1,4);
			SetData(metricsAgregator.getMeanNFila2(),2,3);
			SetData(metricsAgregator.getDeviationNTotal2(), 2, 4);
			SetData(metricsAgregator.getMeanNAtraso2(),3,3);
			SetData(metricsAgregator.getDeviationNAtraso2(), 3, 4);
			SetData(metricsAgregator.getVarianceAtraso2(),4,3);
		}

	}

	public void SetData(Object obj, int row_index, int col_index) {
		tableResult.getModel().setValueAt(obj, row_index, col_index);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
