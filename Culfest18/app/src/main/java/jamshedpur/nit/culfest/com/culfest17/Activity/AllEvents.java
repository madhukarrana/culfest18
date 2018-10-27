package jamshedpur.nit.culfest.com.culfest17.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 25-01-2018.
 */

public class AllEvents {
    public static List<String[]> list;
    public AllEvents(){
        list = new ArrayList<>();
        list.add(new String[]{"Radiance","Choreo Night","Journalism","Halla Bol","Theme Quiz","Poshak","Battle Of Bands"});
        list.add(new String[]{"Foot Loose","Dancing Duo","Shake On Beat","Choreo Night","FaceOff"});
        list.add(new String[]{"Mono Acting","Panch Parmeshwar","Mime","Rangmanch","Halla Bol"});
        list.add(new String[]{"India Quiz","Biztech Quiz","Theme Quiz","Slamies"});
        list.add(new String[]{"Journalism","JAM","Potpourri","Policy Debate","Creative Writing","Poetry Slam","Wit-a-Story","SSMQ"});
        list.add(new String[]{"Culfest Idol","The Voice","Duets","Pitch Perfect","Unplugged","Battle Of Bands"});
        list.add(new String[]{"Rangoli","Face Painting","Soap Carving","Finger Painting","Triathlon","Claydoh","Poshak"});
        list.add(new String[]{"Instant-o-graphy","48-hours"});
        list.add(new String[]{"Ludo","Be The Bean","Blind Date","Henna","Antakshari","House Of Cards","Blind Fold","Big Boss","KBF","Paper Dance","Pillow Fight"});
    }
    public String[] getEvent(int pos){
        return list.get(pos);
    }
}
