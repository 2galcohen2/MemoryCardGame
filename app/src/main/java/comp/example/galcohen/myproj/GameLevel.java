package comp.example.galcohen.myproj;

import java.io.Serializable;

/**
 * Includes the level settings
 */

public class GameLevel implements Serializable {

    final private String EASY_LEVEL = "Easy";
    final private String MED_LEVEL = "Medium";
    final private String HARD_LEVEL = "Hard";

    final private int pairs_num;
    final private int time_in_sec;


    public GameLevel(String stLevel) {

        switch (stLevel) {
            case (EASY_LEVEL):
                this.pairs_num = Constants.EASY_PAIRS;
                this.time_in_sec =  Constants.EASY_TIME;
                break;
            case (MED_LEVEL):
                this.pairs_num = Constants.MED_PAIRS;
                this.time_in_sec =  Constants.MED_TIME;
                break;
            case (HARD_LEVEL):
                this.pairs_num = Constants.HARD_PAIRS;
                this.time_in_sec =  Constants.HARD_TIME;
                break;
            default:
                this.pairs_num = Constants.EASY_PAIRS;
                this.time_in_sec =  Constants.EASY_TIME;
                break;
        }
    }

    public int GetCellsNum()
    {
        return (pairs_num*pairs_num);
    }

    public int GetPairsNum()
    {
        return (this.pairs_num);
    }

}
