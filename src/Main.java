import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		FileWriter arq = new FileWriter("gráfico.html");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		int numTarefas = 0;
		
		System.out.println("Este programa irá gerar um gráfico de suas tarefas diárias (dormir, trabalhar, jogar, estudar...)");
		System.out.println("Por favor digite algo que realize durante o dia, seguido de sua duração em horas..");
		System.out.println("Quantas tarefas realiza no dia?");
		numTarefas = entrada.nextInt();
		String tarefas[] = new String[numTarefas];
		int duracao[] = new int[numTarefas];
		
		for(int i = 0; i < numTarefas; i++) {
			System.out.println("Digite a tarefa número " + (i+1));
			tarefas[i] = entrada.next();
			System.out.println("Quantas horas por dia realiza a tarefa " + tarefas[(i)] + "?");
			duracao[i] = entrada.nextInt();
		}
		
		gravarArq.printf("<html>\r\n" + 
				"  <head>\r\n" + 
				"    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
				"    <script type=\"text/javascript\">\r\n" + 
				"      google.charts.load(\"current\", {packages:[\"corechart\"]});\r\n" + 
				"      google.charts.setOnLoadCallback(drawChart);\r\n" + 
				"      function drawChart() {\r\n" + 
				"        var data = google.visualization.arrayToDataTable([\r\n" + 
				"          ['Tarefa', 'Horas por dia'],\r\n");
		for (int i = 0; i < numTarefas; i++) {
		      gravarArq.printf("          ['"+tarefas[i]+"'," + duracao[i] + "],\r\n");
		}
		gravarArq.printf("]);\r\n" + 
				"\r\n" + 
				"        var options = {\r\n" + 
				"          title: 'Minhas tarefas diárias',\r\n" + 
				"          is3D: true,\r\n" + 
				"        };\r\n" + 
				"\r\n" + 
				"        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));\r\n" + 
				"        chart.draw(data, options);\r\n" + 
				"      }\r\n" + 
				"    </script>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <div id=\"piechart_3d\" style=\"width: 600px; height: 500px;\"></div>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
		arq.close();

		System.out.printf("\nGráfico gravado com sucesso");
		entrada.close();
	}
}