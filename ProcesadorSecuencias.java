import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import java.util.Set;
import java.util.HashSet;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class ProcesadorSecuencias extends Application
{
	private ArrayList<Par> x = new ArrayList<>();
	private ArrayList<Par> y = new ArrayList<>();
	private ArrayList<Par> z = new ArrayList<>();
	private ScatterChart.Series<Number, Number> series1 = new ScatterChart.Series<>();     
	private ScatterChart.Series<Number, Number> series2 = new ScatterChart.Series<>();     
	private ScatterChart.Series<Number, Number> series3 = new ScatterChart.Series<>();     
	NumberAxis xAxis1 = new NumberAxis(-10, 10, 1);
    NumberAxis yAxis1 = new NumberAxis(-10, 10, 1);        
    NumberAxis xAxis2 = new NumberAxis(-10, 10, 1);
    NumberAxis yAxis2 = new NumberAxis(-10, 10, 1);        
    NumberAxis xAxis3 = new NumberAxis(-10, 10, 1);
    NumberAxis yAxis3 = new NumberAxis(-10, 10, 1);        
	ScatterChart<Number,Number> sc1 = new ScatterChart<>(xAxis1, yAxis1);
    ScatterChart<Number,Number> sc2 = new ScatterChart<>(xAxis2, yAxis2);
    ScatterChart<Number,Number> sc3 = new ScatterChart<>(xAxis3, yAxis3);

	@Override
	public void start(Stage primaryStage)
	{
		//---------------------------------------PROCESADOR DE SECUENCIAS---------------------------------
		VBox procesadorPane = new VBox(20);
		HBox hbox1 = new HBox(20);
		HBox hbox2 = new HBox(20);
		HBox hbox3 = new HBox(20);
		HBox hbox4 = new HBox(20);
		Label lbSecuencia1 = new Label("Ingresa la secuencia 1: ");
		Label lbSecuencia2 = new Label("Ingresa la secuencia 2: ");
		Label lbDato = new Label("Dato: ");
		TextField tfSecuencia1 = new TextField();
		TextField tfSecuencia2 = new TextField();
		TextField tfDato = new TextField();
		Button btMostrar = new Button("Mostrar Secuencia");
		Button btSumar = new Button("Sumar");
		Button btRestar = new Button("Restar");
		Button btMultiplicar = new Button("Multiplicar");
		Button btAmplificar = new Button("Amplificar/Atenuar");
		Button btDesplazar = new Button("Desplazar");
		Button btReflejar = new Button("Reflejar");
		Button btDiezmar = new Button("Diezmar");
		Button btInterpolacionCero = new Button("Interpolacion Cero");
		Button btInterpolacionEscalon = new Button("Interpolacion Escalon");
		Button btInterpolacionLineal = new Button("Interpolacion Lineal");
		Button btConvolucion = new Button("Convolucion");
		ToggleGroup tgGroupSecuencia = new ToggleGroup();
		RadioButton rbSecuencia1 = new RadioButton("Sec 1");
		RadioButton rbSecuencia2 = new RadioButton("Sec 2");
		RadioButton rbSecuencia3 = new RadioButton("Sec 3");
		
        xAxis1.setLabel("k");                
        yAxis1.setLabel("n(k)");
        xAxis2.setLabel("k");                
        yAxis2.setLabel("n(k)");
        xAxis3.setLabel("k");                
        yAxis3.setLabel("n(k)");
        xAxis1.setAutoRanging(true);
        xAxis2.setAutoRanging(true);
        xAxis3.setAutoRanging(true);
    	yAxis1.setAutoRanging(true);
    	yAxis2.setAutoRanging(true);
    	yAxis3.setAutoRanging(true);
        sc1.setTitle("Secuencia 1");
        sc2.setTitle("Secuencia 2");
        sc3.setTitle("Secuencia 3");
        series1.setName("Secuencia 1");
	    series2.setName("Secuencia 2");
	    series3.setName("Secuencia 3");

	    tfSecuencia1.setPrefColumnCount(28);
	    tfSecuencia2.setPrefColumnCount(28);
	    tfDato.setPrefColumnCount(3);

		procesadorPane.setPadding(new Insets(5));
		hbox1.setPadding(new Insets(5));
		hbox2.setPadding(new Insets(5));
		hbox3.setPadding(new Insets(5));
		hbox4.setPadding(new Insets(5));

		rbSecuencia1.setToggleGroup(tgGroupSecuencia);
		rbSecuencia2.setToggleGroup(tgGroupSecuencia);
		rbSecuencia3.setToggleGroup(tgGroupSecuencia);
		
		hbox1.getChildren().addAll(lbSecuencia1, tfSecuencia1, lbSecuencia2, tfSecuencia2, lbDato, tfDato, rbSecuencia1, rbSecuencia2, rbSecuencia3);
		hbox2.getChildren().addAll(btMostrar, btSumar, btRestar, btMultiplicar, btAmplificar, btDesplazar, btReflejar, btDiezmar);
		hbox3.getChildren().addAll(btInterpolacionCero, btInterpolacionEscalon, btInterpolacionLineal, btConvolucion);
		hbox4.getChildren().addAll(sc1, sc2, sc3);
		procesadorPane.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);

		Scene scene = new Scene(procesadorPane, 1400, 700);
		scene.getStylesheets().add("/Chart.css");
		primaryStage.setScene(scene);
		primaryStage.setTitle("PROCESADOR DE SECUENCIAS");			
		primaryStage.show();

		btMostrar.setOnAction
		(
			e -> 
			{
				if(rbSecuencia1.isSelected())
				{
					x.clear();
					String s1 = tfSecuencia1.getText();			
					int origen = Integer.parseInt(tfDato.getText());
					String array1[] = s1.split(" ");
					int i = 0, j = 0;

					//Llenando el arreglo
					for(String s: array1)
					{
						if(i == origen)
						{
							x.add(new Par(0, Double.parseDouble(array1[i])));
							i++;
						}
						else
						{
							x.add(new Par(-1, Double.parseDouble(array1[i])));
							i++;
						}
					}
					//Colocando sus posiciones	
					for(i = 0; i < origen; i++)
					{
						x.get(i).setPos(i - origen);
					}
					for(j = origen + 1, i = 1; j < x.size(); j++)
					{
						x.get(j).setPos(i++);
					}
					//Vaciando el chart
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}
					//Poniendo la nueva información en el chart
					series1 = new ScatterChart.Series<>();
					for(i = 0; i < x.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(x.get(i).getPos(), x.get(i).getValor()));
		            }
		            sc1.getData().add(series1);	
		        }
				else if(rbSecuencia2.isSelected())
				{
					y.clear();
					String s2 = tfSecuencia2.getText();			
					int origen = Integer.parseInt(tfDato.getText());
					String array2[] = s2.split(" ");
					int i = 0, j = 0;

					//Llenando el arreglo
					for(String s: array2)
					{
						if(i == origen)
						{
							y.add(new Par(0, Double.parseDouble(array2[i])));
							i++;
						}
						else
						{
							y.add(new Par(-1, Double.parseDouble(array2[i])));
							i++;
						}
					}
					//Colocando sus posiciones	
					for(i = 0; i < origen; i++)
					{
						y.get(i).setPos(i - origen);
					}
					for(j = origen + 1, i = 1; j < y.size(); j++)
					{
						y.get(j).setPos(i++);
					}						
					//Vaciando el chart
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}
					System.out.println("AA");;
					//Poniendo la nueva información en el chart
					series2 = new ScatterChart.Series<>();
					for(i = 0; i < y.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(y.get(i).getPos(), y.get(i).getValor()));
		            }
		            sc2.getData().add(series2);	
				}
			}
		);

		btAmplificar.setOnAction
		(
			e -> 
			{
				double escalar = Double.parseDouble(tfDato.getText());
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}

					ArrayList<Par> amp = new Amplificacion(x).amplificarAtenuar(escalar);
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}

					ArrayList<Par> amp = new Amplificacion(y).amplificarAtenuar(escalar);
					series2 = new ScatterChart.Series<>(); 
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}

					ArrayList<Par> amp = new Amplificacion(z).amplificarAtenuar(escalar);
					series3 = new ScatterChart.Series<>(); 
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);
				}
			}
		);

		btReflejar.setOnAction
		(
			e -> 
			{
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}
					ArrayList<Par> amp = new Reflejo(x).reflejar();
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}
					ArrayList<Par> amp = new Reflejo(y).reflejar();
					series2 = new ScatterChart.Series<>();
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);	
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}
					ArrayList<Par> amp = new Reflejo(z).reflejar();
					series3 = new ScatterChart.Series<>();
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);	
				}
			}
		);

		btDesplazar.setOnAction
		(
			e -> 
			{
				int escalar = Integer.parseInt(tfDato.getText());
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}
					ArrayList<Par> amp = new Desplazamiento(x).desplazar(escalar);
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}
					ArrayList<Par> amp = new Desplazamiento(y).desplazar(escalar);
					series2 = new ScatterChart.Series<>();
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}
					ArrayList<Par> amp = new Desplazamiento(z).desplazar(escalar);
					series3 = new ScatterChart.Series<>();
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);
				}	
			}
		);

		btSumar.setOnAction
		(
			e -> 
			{
				if(!sc3.getData().isEmpty())
				{
					sc3.getData().remove(0);
				}
				z = new Aritmetica().suma(x, y);
				series3 = new ScatterChart.Series<>();
            	series3.setName("Secuencia 3");
	            for(int i = 0; i < z.size(); i++) 
	            {
	                series3.getData().add(new ScatterChart.Data<>(z.get(i).getPos(), z.get(i).getValor()));
	            }
	            sc3.getData().add(series3);
			}
		);

		btRestar.setOnAction
		(
			e -> 
			{
				if(!sc3.getData().isEmpty())
				{
					sc3.getData().remove(0);
				}

				z = new Aritmetica().resta(x, y);
				series3 = new ScatterChart.Series<>();
            	series3.setName("Secuencia 3");
	            for(int i = 0; i < z.size(); i++) 
	            {
	                series3.getData().add(new ScatterChart.Data<>(z.get(i).getPos(), z.get(i).getValor()));
	            }
	            sc3.getData().add(series3);
			}
		);

		btMultiplicar.setOnAction
		(
			e -> 
			{
				if(!sc3.getData().isEmpty())
				{
					sc3.getData().remove(0);
				}
				z = new Aritmetica().multiplicacion(x, y);
				series3 = new ScatterChart.Series<>();
            	series3.setName("Secuencia 3");
	            for(int i = 0; i < z.size(); i++) 
	            {
	                series3.getData().add(new ScatterChart.Data<>(z.get(i).getPos(), z.get(i).getValor()));
	            }
	            sc3.getData().add(series3);
			}
		);

		btDiezmar.setOnAction
		(
			e -> 
			{
				int escalar = Integer.parseInt(tfDato.getText());
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}

					ArrayList<Par> amp = new Diezmacion().diezmar(x, escalar);
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}

					ArrayList<Par> amp = new Diezmacion().diezmar(y, escalar);
					series2 = new ScatterChart.Series<>(); 
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}

					ArrayList<Par> amp = new Diezmacion().diezmar(z, escalar);
					series3 = new ScatterChart.Series<>(); 
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);
				}
			}
		);

		btInterpolacionLineal.setOnAction
		(
			e -> 
			{
				int escalar = Integer.parseInt(tfDato.getText());
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionLineal(x, escalar);
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionLineal(y, escalar);
					series2 = new ScatterChart.Series<>(); 
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionLineal(z, escalar);
					series3 = new ScatterChart.Series<>(); 
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);
				}
			}
		);

		btInterpolacionEscalon.setOnAction
		(
			e -> 
			{
				int escalar = Integer.parseInt(tfDato.getText());
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionEscalon(x, escalar);
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionEscalon(y, escalar);
					series2 = new ScatterChart.Series<>(); 
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionEscalon(z, escalar);
					series3 = new ScatterChart.Series<>(); 
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);
				}
			}
		);

		btInterpolacionCero.setOnAction
		(
			e -> 
			{
				int escalar = Integer.parseInt(tfDato.getText());
				if(rbSecuencia1.isSelected())
				{
					if(!sc1.getData().isEmpty())
					{
						sc1.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionCero(x, escalar);
					series1 = new ScatterChart.Series<>();
	            	series1.setName("Secuencia 1");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series1.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc1.getData().add(series1);
				}
				else if(rbSecuencia2.isSelected())
				{
					if(!sc2.getData().isEmpty())
					{
						sc2.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionCero(y, escalar);
					series2 = new ScatterChart.Series<>(); 
	            	series2.setName("Secuencia 2");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series2.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc2.getData().add(series2);
				}
				else if(rbSecuencia3.isSelected())
				{
					if(!sc3.getData().isEmpty())
					{
						sc3.getData().remove(0);
					}

					ArrayList<Par> amp = new Interpolacion().interpolacionCero(z, escalar);
					series3 = new ScatterChart.Series<>(); 
	            	series3.setName("Secuencia 3");
		            for(int i = 0; i < amp.size(); i++) 
		            {
		                series3.getData().add(new ScatterChart.Data<>(amp.get(i).getPos(), amp.get(i).getValor()));
		            }
		            sc3.getData().add(series3);
				}
			}
		);

		btConvolucion.setOnAction
		(
			e -> 
			{
				if(!sc3.getData().isEmpty())
				{
					sc3.getData().remove(0);
				}
				z = new Convolucion().convolucionar(x, y);
				series3 = new ScatterChart.Series<>();
            	series3.setName("Secuencia 3");
	            for(int i = 0; i < z.size(); i++) 
	            {
	                series3.getData().add(new ScatterChart.Data<>(z.get(i).getPos(), z.get(i).getValor()));
	            }
	            sc3.getData().add(series3);
			}
		);
	}	
}