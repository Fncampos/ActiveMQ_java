package filaveiculo;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class ConsumerFila {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL; // "vm://localhost";
   
    private static String subject = "VEICULO"; //Nome da fila ou topico para onde enviaremos a mensagem
    
    private static void consumir() throws JMSException {
        // cria a fabrica de conexao e inicia a conexao
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // Cria sessão para consumir a mensagem
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // Cria a fila destino (Queue)
        Destination destination = session.createQueue(subject);
        // Cria uma MessageConsumer da Session do Topic or Queue
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive(15000);

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            
            System.out.println("\n\nRecebi da Fila a msg = '" + textMessage.getText() + "'");
            if (textMessage.getText().toLowerCase().contains("xml")) {
            	recuperaMensagemObjeto(textMessage);
            }
        } else {
            System.out.println("** SEM MENSAGENS **  ");
        }
        
        consumer.close();
        session.close();
        connection.close();
    }
    
    private static void recuperaMensagemObjeto(TextMessage msg) throws JMSException {
    	// consumer side:
    	TextMessage tmsg = (TextMessage)msg;
    	
    	// instancia um XStream
        XStream xstream = new XStream(new StaxDriver());
    	        
        xstream.addPermission(AnyTypePermission.ANY);
        
        Veiculo par = (Veiculo) xstream.fromXML(tmsg.getText());
        
        System.out.println("\n\n-----------DADOS VEICULO--------------------------------");
        System.out.println("Cliente: " + par.getNomeCliente());
        System.out.println("Marca e Modelo: " + par.getMarcaModeloVeiculo());
        System.out.println("Ano Fabricação: " + par.getAnoModelo());
        System.out.println("Valor: " + par.getValorVenda());
        System.out.println("Data da publicação: " + par.getDataPublicacao());
    	 
    }
    
    public static void main(String[] args) throws JMSException {
        while (true) {
            consumir();
        } 
    }
}
