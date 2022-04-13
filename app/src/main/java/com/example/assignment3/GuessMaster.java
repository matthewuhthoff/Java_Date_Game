package com.example.assignment3;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.widget.*;
import android.os.Bundle;
import java.util.Random;

public class GuessMaster extends AppCompatActivity{
    private int numOfEntities;
    public Entity[] entities;
    private Integer tickets = 0; // added int to keep track of users score
    private int[] imageList;
    private Entity currTarget;

    private TextView ticketsum;
    private ImageView entityImage;
    private TextView entityName;
    private EditText userIn;
    private Button guessButton;
    private String user_input;
    private boolean goBack = false;
    private Integer prevId;
    private int duplicate = 7;


    private float x1,x2; // used for swipe detection
    static final int MIN_DISTANCE = 150;


    public GuessMaster() {
        numOfEntities = 0;
        entities = new Entity[100];
    }

    public void addEntity(Entity entity) {
        entities[numOfEntities++] = entity.clone();
    }


    public void playGame(Entity entity) {

        try {
            user_input = userIn.getText().toString();
            user_input = user_input.replace("\n", "").replace("\r", "").replace("-", "/");


            Date date = new Date(user_input);


            if (date.precedes(entity.getBorn())) {
                Toast.makeText(getBaseContext(), "Incorrect. Try a later date.", Toast.LENGTH_SHORT).show();
            } else if (entity.getBorn().precedes(date)) {
                Toast.makeText(getBaseContext(), "Incorrect. Try an earlier date.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), "Congrats, you win!!", Toast.LENGTH_SHORT).show();
                userIn.getText().clear();
                tickets += entity.getAwardedTicketNumber();
                currTarget = makeScreen(duplicate);
            }
        } catch (Exception e){
            Toast.makeText(getBaseContext(), "Incorrect formatting bozo", Toast.LENGTH_SHORT).show();
        }
    }

    public Entity makeScreen(int check){
        int entityId;
        do {
            Random randomNumber = new Random();
            entityId = randomNumber.nextInt(numOfEntities);
        } while (entityId == check);
        prevId = entityId;
        duplicate = entityId;
        entityImage.setImageResource((int)imageList[entityId]);
        ticketsum.setText("Tickets: " + tickets.toString());
        Entity entity = entities[entityId];
        entityName.setText(entity.getName());
        return entity;
    }

    public Entity makeScreen2(int check){
        int entityId;
        do {
            Random randomNumber = new Random();
            entityId = randomNumber.nextInt(numOfEntities);
        } while (entityId == check);
        duplicate = entityId;
        entityImage.setImageResource((int)imageList[entityId]);
        ticketsum.setText("Tickets: " + tickets.toString());
        Entity entity = entities[entityId];
        entityName.setText(entity.getName());
        return entity;
    }

    public Entity makeScreen3(Integer entityId){
        entityImage.setImageResource((int)imageList[entityId]);
        ticketsum.setText("Tickets: " + tickets.toString());
        Entity entity = entities[entityId];
        entityName.setText(entity.getName());
        return entity;
    }


    public void welcomeToGame(Entity entity){
        AlertDialog.Builder welcomeAlert = new AlertDialog.Builder(GuessMaster.this);
        welcomeAlert.setTitle("GuessMaster Game 3.0");
        welcomeAlert.setMessage(entity.welcomeMessage());
        welcomeAlert.setCancelable(false);
        welcomeAlert.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Game is Starting .. Enjoy!", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = welcomeAlert.create();
        dialog.show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticketsum = findViewById(R.id.ticket);
        entityImage = findViewById(R.id.entityImage);
        entityName = findViewById(R.id.entityName);
        userIn = findViewById(R.id.guessInput);
        guessButton = findViewById(R.id.btnGuess);


        setup();
        currTarget = makeScreen(duplicate);
        welcomeToGame(currTarget);

        guessButton.setOnClickListener(v -> {
            playGame(currTarget);
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    if (x1 > x2){
                        userIn.getText().clear();
                        currTarget = makeScreen2(duplicate);
                        goBack = true;
                    }

                    if (x2 > x1 && goBack){

                        userIn.getText().clear();
                        currTarget = makeScreen3(prevId);
                        goBack = false;

                    }


                }
                break;
        }
        return super.onTouchEvent(event);
    }


    public void setup() {
        Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25,1971), "Male", "Liberal", 0.25);
        Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female" , "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
        Person myCreator = new Person("myCreator", new Date("September", 1, 2000),"Female", 1);
        Country usa = new Country("United States", new Date("July", 4, 1776), "Washinton D.C.", 0.1);

        addEntity(trudeau);
        addEntity(dion);
        addEntity(myCreator);
        addEntity(usa);

        imageList = new int[] {R.drawable.justint, R.drawable.celidion, R.drawable.temperr, R.drawable.usaflag};



    }
}