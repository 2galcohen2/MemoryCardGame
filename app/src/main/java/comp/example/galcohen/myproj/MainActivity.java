package comp.example.galcohen.myproj;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.widget.*;
import android.view.View;

import comp.example.galcohen.myproj.*;


public class MainActivity extends AppCompatActivity {

    GridView gvBoard;
    Card[] cardsArr;
    Card firstCard;
    Card currCard;
    int pairs_found;
    CardAdapter cardAdapter;
    Toast toast;
    Handler handler;
    Runnable timerRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvBoard = (GridView) findViewById(R.id.gvBoard);
        final GameLevel glLevel;

        handler = new Handler();
        timerRunnable = new Runnable() {
            @Override
            public void run() {
                TurnCards();
            }
        };

        glLevel = (GameLevel)getIntent().getSerializableExtra("gameLevel");
        BuildGameBoard(glLevel);

        gvBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                currCard = cardsArr[position];
                Context context = getApplicationContext();

                //Only if card not clicked yet the user can click it
                if (!currCard.IsCardClicked())
                {
                    //If it the second card, check for match. else just save it for next click
                    if (firstCard != null){

                        if(currCard.IsCardMatch(firstCard)){
                            currCard.ClickImage();
                            firstCard = null;

                            //Check for win
                            if (++pairs_found == glLevel.GetPairsNum()){
                                toast = Toast.makeText(context, Messages.WIN_MES, Toast.LENGTH_SHORT);
                                toast.show();
                            }

                        }else{
                            currCard.ClickImage();
                            handler.postDelayed(timerRunnable, 1000);
                        }

                    }else{
                        currCard.ClickImage();
                        firstCard = currCard;
                    }

                    // This tells the GridView to redraw itself
                    // in turn calling your BooksAdapter's getView method again for each cell
                    cardAdapter.notifyDataSetChanged();
                }else
                {
                    toast = Toast.makeText(context, Messages.CARD_CLICKED, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    //Build the game board according to the selected level
    public void BuildGameBoard(GameLevel glLevel) {
        cardsArr = new Card[glLevel.GetCellsNum()];
        int cardsNum = glLevel.GetCellsNum();
        int index = 0;
        pairs_found = 0;

        //There are at list 4 cards
        cardsArr[index++] = new Card(101, 201, R.drawable.im101);
        cardsArr[index++] = new Card(102, 202, R.drawable.im102);

        cardsArr[index++] = new Card(201, 101, R.drawable.im201);
        cardsArr[index++] = new Card(202, 102, R.drawable.im202);

        //If not easy level
        if (cardsNum > index) {
            cardsArr[index++] = new Card(103, 203, R.drawable.im103);
            cardsArr[index++] = new Card(104, 204, R.drawable.im104);
            cardsArr[index++] = new Card(105, 205, R.drawable.im105);
            cardsArr[index++] = new Card(106, 206, R.drawable.im106);
            cardsArr[index++] = new Card(107, 207, R.drawable.im107);
            cardsArr[index++] = new Card(108, 208, R.drawable.im108);

            cardsArr[index++] = new Card(203, 103, R.drawable.im203);
            cardsArr[index++] = new Card(204, 104, R.drawable.im204);
            cardsArr[index++] = new Card(205, 105, R.drawable.im205);
            cardsArr[index++] = new Card(206, 106, R.drawable.im206);
            cardsArr[index++] = new Card(207, 107, R.drawable.im207);
            cardsArr[index++] = new Card(208, 108, R.drawable.im208);

            //If not medium level
            if (cardsNum > index) {
                cardsArr[index++] = new Card(109, 209, R.drawable.im109);
                cardsArr[index++] = new Card(110, 210, R.drawable.im110);
                cardsArr[index++] = new Card(111, 211, R.drawable.im111);
                cardsArr[index++] = new Card(112, 212, R.drawable.im112);
                cardsArr[index++] = new Card(113, 213, R.drawable.im113);
                cardsArr[index++] = new Card(114, 214, R.drawable.im114);
                cardsArr[index++] = new Card(115, 215, R.drawable.im115);
                cardsArr[index++] = new Card(116, 216, R.drawable.im116);
                cardsArr[index++] = new Card(117, 217, R.drawable.im117);
                cardsArr[index++] = new Card(118, 218, R.drawable.im118);

                cardsArr[index++] = new Card(209, 109, R.drawable.im209);
                cardsArr[index++] = new Card(210, 110, R.drawable.im210);
                cardsArr[index++] = new Card(211, 111, R.drawable.im211);
                cardsArr[index++] = new Card(212, 112, R.drawable.im212);
                cardsArr[index++] = new Card(213, 113, R.drawable.im213);
                cardsArr[index++] = new Card(214, 114, R.drawable.im214);
                cardsArr[index++] = new Card(215, 115, R.drawable.im215);
                cardsArr[index++] = new Card(216, 116, R.drawable.im216);
                cardsArr[index++] = new Card(217, 117, R.drawable.im217);
                cardsArr[index++] = new Card(218, 118, R.drawable.im218);
            }
        }

        cardAdapter = new CardAdapter(this, cardsArr);
        gvBoard.setAdapter(cardAdapter);
    }

    public void TurnCards(){
        currCard.ClickImage();
        firstCard.ClickImage();
        firstCard = null;
        cardAdapter.notifyDataSetChanged();
    }

}
