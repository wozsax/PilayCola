import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{

    Stage window = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PilaPura<Integer> stack = new PilaPura<>();
        ColaPura<Integer> queue = new ColaPura<>();

        HBox hbox = new HBox();
        VBox primera = new VBox();
        VBox menu = new VBox(10);
        VBox segunda = new VBox();

        Label pila = new Label();
        pila.setText("Pila");
        Label cola = new Label();
        cola.setText("Cola");
        TextArea pilaText = new TextArea();
        TextArea colaText = new TextArea();
        pilaText.setEditable(false);
        colaText.setEditable(false);

        TextField input = new TextField();
        Button pushPila = new Button("Push");
        Button popPila = new Button("Pop");
        Button enqueueCola = new Button("Enqueue");
        Button dequeueCola = new Button("Dequeue");
        Button peekPila = new Button("Peek Pila");
        Button peekCola = new Button("Peek Cola");

        Label resultado = new Label();

        primera.getChildren().addAll(pila,pilaText);
        segunda.getChildren().addAll(cola,colaText);
        menu.getChildren().addAll(input,pushPila,popPila,enqueueCola,dequeueCola,
                peekPila,peekCola,resultado);
        hbox.getChildren().addAll(primera,menu,segunda);    // root node

        pushPila.setOnAction(e -> {
            String valor = input.getText();
            if (valor.length()>0){
                stack.push(Integer.parseInt(valor));
                pilaText.setText(stack.toString());
            }
        });

        popPila.setOnAction(e -> {
            if(!stack.isEmpty()){
                String popped = stack.pop().toString();
                resultado.setText("Resultado: "+ popped);
                pilaText.setText(stack.toString());
            }
        });

        enqueueCola.setOnAction(e -> {
            String valor = input.getText();
            if(valor.length()>0){
                queue.enqueue(Integer.parseInt(valor));
                colaText.setText(queue.toString());
            }
        });

        dequeueCola.setOnAction(e -> {
            if(!queue.isEmpty()) {
                String dequeued = queue.dequeue().toString();
                resultado.setText("Resultado: " + dequeued);
                colaText.setText(queue.toString());
            }
        });

        peekPila.setOnAction(e -> {
            if (queue.isEmpty()){
                resultado.setText("Pila está vacía.");
            }else{
                resultado.setText("Resultado:" + stack.peek().toString());
            }
        });
        peekCola.setOnAction(e -> {
            if (queue.isEmpty()){
                resultado.setText("Cola está vacía.");
            }else{
                resultado.setText("Resultado:" + queue.peek().toString());
            }
        });

        window = primaryStage;
        window.setTitle("Pila y Cola");
        Scene mainScene = new Scene(hbox, 900,500);
        window.setScene(mainScene);
        window.show();

    }
}