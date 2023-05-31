import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1;
    private static final int THRESHOLD = 80; // Niveau de seuil prédéfini (80%)
    private int currentFillLevel = 0; // Niveau de remplissage actuel de la poubelle
    public static void main(String[] args) {
    	 @Override
    	    protected void onCreate(Bundle savedInstanceState) {
    	        super.onCreate(savedInstanceState);
    	        setContentView(R.layout.activity_main);

    	        // Simuler le changement de niveau de remplissage (pour les tests)
    	        updateFillLevel(75);

    	        // Vérifier le niveau de remplissage toutes les X secondes (par exemple, toutes les 10 secondes)
    	        Thread thread = new Thread(new Runnable() {
    	            @Override
    	            public void run() {
    	                while (true) {
    	                    checkFillLevel();
    	                    try {
    	                        Thread.sleep(10000); // Attente de 10 secondes
    	                    } catch (InterruptedException e) {
    	                        e.printStackTrace();
    	                    }
    	                }
    	            }
    	        
    	        thread.start();
    	 }
    }

    	    // Méthode pour mettre à jour le niveau de remplissage de la poubelle
    	    private void updateFillLevel(int fillLevel) 
    	    {
    	        currentFillLevel = fillLevel;
    	    }

    	    // Méthode pour vérifier le niveau de remplissage et envoyer une notification si le seuil est atteint
    	    private void checkFillLevel() {
    	        if (currentFillLevel >= THRESHOLD) {
    	            sendNotification("La poubelle est presque pleine!");
    	        }
    	    }

    	    // Méthode pour envoyer une notification aux utilisateurs
    	    private void sendNotification(String message) {
    	        Intent intent = new Intent(this, MainActivity.class);
    	        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    	        Notification.Builder builder = new Notification.Builder(this)
    	                .setSmallIcon(R.drawable.ic_notification)
    	                .setContentTitle("Notification Poubelle Intelligente")
    	                .setContentText(message)
    	                .setContentIntent(pendingIntent);

    	        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    	        notificationManager.notify(NOTIFICATION_ID, builder.build());
    	    }
    	}

    }