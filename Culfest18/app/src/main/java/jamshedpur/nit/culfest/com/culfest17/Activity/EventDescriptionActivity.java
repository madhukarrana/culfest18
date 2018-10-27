package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.HashMap;

import jamshedpur.nit.culfest.com.culfest17.R;

public class EventDescriptionActivity extends AppCompatActivity {


    TextView cardText;
    String event;
    HashMap<String,EventModel> eventList;
    TextView cardTitle;
    Typeface typeface1;
    Typeface typeface2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        disableShiftMode(bottomNavigationView);
        cardText=(TextView) findViewById(R.id.event_text);
        cardTitle=(TextView)findViewById(R.id.event_title);
        Bundle extras=getIntent().getExtras();
        event=extras.getString("EventName");

        typeface1 = Typeface.createFromAsset(getAssets(), "fonts/BebasNeue.otf");
        typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Gravity-Regular.otf");



        eventList=new HashMap<>();
        eventList.put("Face Painting",new EventModel("Face painting ",
                "Life is a great big canvas, and we should throw all the paint on it. Face painting is an event which true to its name, provides the participants the opportunity to smear the faces of their partners with myriad hues as per the themes provided. All those who dream of transforming people into butterflies, ghosts, witches or animals... FACES presents a perfect stage, this Culfest 2018 to transform your dreams into reality. Grab the opportunity to paint picturesque faces and sail away with exciting prizes. ",
                "1. There should be 2 members in each and every team. \n" +
                        "\n2. Participants are not allowed to use anything except materials provided by us. \n" +
                        "\n3. Time limit is 1 hour. \n" +
                        "\n4. Teams are not allowed to take any kind of external help. \n" +
                        "\n5. Participants must bring their Culfest registration card. \n" +
                        "\n6. If any team found guilty of violating rules, it would be eliminated. \n" +
                        "\n8. Skin friendly colours will be provided. \n" +
                        "\n9. Theme will be provided on the spot. \n",
                "1. Siney (8235378454)\n"+
                        "2. Anmol (9801119003)",
                "7,200\n",
                "3,200",
                "2,400",
                "1,600"));

        eventList.put("Soap Carving",new EventModel("Soap Carving ",
                "Soap carving can be an interesting pastime, a hobby that can be enjoyed by both the young and the old. So why not just grab a chisel and start shaping your imagination and make your own Disney world come true in this Culfest 2018. ",
                "1. This is a solo event. \n" +
                        "\n2. Time limit is 1 hour. \n" +
                        "\n3.  Participants are not allowed to use anything except materials provided by us \n" +
                        "\n4.  Teams are not allowed to take any kind of external help. \n" +
                        "\n5.  Participants must bring their Culfest registration card. \n" +
                        "\n6. If any team found guilty of violating rules, it would be eliminated. \n" +
                        "\n7. Theme will be provided on the spot. \n" ,
                "1. Komal (7856991162)\n"+
                        "2. Shubham Anand (9661398598)",
                "5,000\n",
                "2,500",
                "1,500",
                "1,000"));

        eventList.put("Finger Painting",new EventModel("Finger painting",
                "No matter whether its brush or finger, a painter can exhibit his creativity with any tool. So this culfest get ready to dip your fingers in the paint !",
                "1. This is an individual event.\n" +
                        "\n2. Participants are needed to make a painting based on the theme given to them on the spot.\n" +
                        "\n3. Participants have to use only fingers for making the painting, no other modes (like brush, stick,folded paper etc.) should be used.\n" +
                        "\n4. All logistics shall be provided on the spot. No additional logistics apart from those provided in the beginning can be used.\n" +
                        "\n5. Use of any outside aids and internet is strictly prohibited and this may lead to the disqualification\n",
                "1. Abhishek ( 8797802331)\n"+
                        "2. Jeet (8987580314)",
                "5,000\n",
                "2,500",
                "1,500",
                "1,000"));

        eventList.put("Rangoli",new EventModel("Rangoli ",
                "Rangoli’s are a visual treat due to their intricacy and varied colours present in it. They have been an integral part of Indian culture, finding their place both during festivities, rituals and hospitable occasions. FACES provides you an opportunity to show the beauty of your thoughts blended with the artistry you possess and add colours to the sunset sky; by floating colourful clouds and win exciting prizes.",
                "Rules for Round 1 \n" +
                        "1. Participants are not allowed to use anything except materials provided by Co-coordinator. \n" +
                        "\n2. Participants must bring their Culfest registration card. \n" +
                        "\n3. Teams are not allowed to take any kind of external help. \n" +
                        "\n4. If any team found guilty of violating rules, that team would be eliminated. \n" +
                        "\n5. There should be 2 members in each and every team. \n" +
                        "\n Rules for Round 2 \n" +
                        "\n1. Time limit is 2 hours. \n" +
                        "\n2. Limited colours will be provided. \n" +
                        "\n3. Participants will have to make the same rangoli which they have drawn in round 1 otherwise team will be eliminated\n",
                "1. Bharath (7255942312)\n"+
                        "2. Bhargav (9177634929)",
                "7,200\n",
                "3,200",
                "2,400",
                "1,600"));

        eventList.put("Triathlon",new EventModel("Triathlon",
                "Sketching is the breath of art. It helps to put feelings into a drawing. Culfest’18 brings to you this event which explores the artist within you. So bring out the best in you and showcase your skills with the majestic strokes of a pencil. Put down your vivid imagination diffused with your aesthetic sense and show the world the power of the artist within you. So gear up for this upcoming event which presents you with a 3 in 1 opportunity to give dimensions to your feelings.",
                "1. Team event (2 members per team) \n" +
                        "\n2. Participants are supposed to use only those materials provided by coordinators. \n" +
                        "\n3. Participants must bring their Culfest registration card. \n" +
                        "\n4. If any team found guilty of violating rules, it would be eliminated. \n" +
                        "\n5. Time Limit of the event is 1 hr. \n" +
                        "\n6. It is a Theme based event\n",
                "1. Shubhangi (7209743044)\n"+
                        "2. Nidhaan (7295867344)\n",
                "9,200\n",
                "4,200",
                "3,000",
                "2,000"));

        eventList.put("Claydoh",new EventModel("Claydoh ",
                "Squeezing and squishing through the dough, moulding and giving wings to our imagination is what this event is all about. The tangible nature of clay makes it feasible to mould it to different shapes and sculptures which combined with the remedial effects it offers Makes it enjoyable for both kids and adults alike to play with it. Culfest’18 presents this fun filled event to create 3-d models and bag a prize!!",
                "1. Team event (2 members per team). \n" +
                        "\n2. Participants are supposed to use only those materials provided by coordinators. \n" +
                        "\n3. Participants must bring their Culfest registration card. \n" +
                        "\n4. If any team found guilty of violating rules, that team would be eliminated. \n" +
                        "\n5. Time Limit of the event is 1.5 hr. \n" +
                        "\n6. It is a theme based event \n",
                "1. Vikash (7209612508)\n"+
                        "2. Mansi (9973946940)\n",
                "7,200\n",
                "3,200",
                "2,400",
                "1,600"));

        eventList.put("Poshak",new EventModel("Poshak",
                "‘We love your style when you face up to our challenge of inventing it. ’ Do you believe in creativity? Do you think some fragments of newspaper and an urn of glue is  sufficient to fashion a dress? Then visit your mind palace for inventive designs and prepare to drape your friend with your scrap ensembles. POSHAK is your chance of shaping ordinary into extraordinary. Fashion beseeches you to set new trends! \n",
                "1. There can be a maximum of 3 members and minimum 2 in each and every team. \n" +
                        "\n2. Participants are not allowed to use anything except materials provided by Co-coordinator. \n" +
                        "\n3. Time limit is 1 hour. \n" +
                        "\n4. Teams are not allowed to take any kind of external help. \n" +
                        "\n5. Participants must bring their Culfest registration card. \n" +
                        "\n6. If any team found guilty of violating rules, it would be eliminated. \n" +
                        "\n7. It is a theme based event.\n",
                "1. Suchii (9135689624 )\n"+
                        "2. Vikrant ( 8294484301 )\n",
                "15,000\n",
                "7,000",
                "5,000",
                "3,000"));

        eventList.put("Mono Acting",new EventModel("MONOACTING",
                "To be yourself is easy, but what does it take to become someone else?Putting up a mask not to " +
                        "hide yourself but to expose? Here's a challenge of Culfest'18 of monoacting competition where " +
                        "being yourself is just not enough .\n" +
                        "Monoacting is a solo performance, featuring an actor who stands on stage and entertains .It's " +
                        "Time you hone your performances or explore your own imagination.\n",
                "1. This is an individual event\n" +
                        "\n2. Inappropriate content, blasphemy or content defaming any political or religious " +
                        "group is strictly prohibited.\n" +
                        "\n3. Music will be allowed in both rounds while the lights will be allowed only in the finals.\n" +
                        "\n4. Any kind of fluid, flame, live animals, heavy objects or any kind of material that " +
                        "damages the stage is strictly not allowed and may lead to disqualification.\n" +
                        " \n5. Prerecorded music is allowed and should be brought in a CD/DVD or a pen drive " +
                        "in .cda or .mp3 format only. (Other formats may not be supported in the " +
                        "computer – use them at your own risk).\n" +
                        "\n6. Participants will be provided a laptop and are expected to appoint someone to " +
                        "operate the laptop during performance.\n" +
                        "\n7. The duration of the act will be 3 to 6 minutes.\n" +
                        "\n8. The participant has to perform for at least 3 mins.\n" +
                        "\n9. If a participant exceeds the stipulated time, 15% of the total marks obtained will " +
                        "be deducted. If he/she exceeds 7 mins, he/she stands to be debarred from the event.\n" +
                        "\n10. The organizing team reserves the right to change or modify any of the rules.\n" +
                        "\n11. The decision of judges will be final and binding.\n",
                "1. Tanisha (9122369515)\n" +
                        "2. Vikash (9097755514)\n",
                "4,800\n",
                "2,500",
                "1,500",
                "800"));

        eventList.put("Halla Bol",new EventModel("HALLA BOL",
                "Natak is not only for entertainment, but also a weapon to fight with different\n" +
                        "conservative mindsets in our society. This Culfest'18 shout from the rooftops and get " +
                        "things in perspective.\n" +
                        "You don't really need a rooftop to shout from the rooftop. Halla bol involves the\n" +
                        "presentation in outdoor public spaces without a specific and paying audience but a fairly " +
                        "large group. Use the art of entertainment to convey a message to the community. Halla " +
                        "bol is a street play competition.\n" +
                        "\n Participants can register from the following link\n\n" +
                        "https://goo.gl/PbLUma" +
                        "\n\n",
                "1. One member can participate as a member of maximum two teams.\n" +
                        "\n2. Two teams can have a maximum of five members in common.\n" +
                        "\n3. Each team can consist of a minimum of 12 to a maximum of 18 members.\n" +
                        "\n4. There must be at least four boys and four girls in a team excluding drummer.\n" +
                        "\n5. Each member should have proper involvement in the team.\n" +
                        "\n6. Time limit for each performance is minimum 10 mins and maximum 20 mins.\n" +
                        "\n7. Teams are free to use simple props (Dupatta, Lathi, Gulaal, Paint, etc.) in their act of performance.\n" +
                        "\n8. The organizing committee shall not provide any Costume/Props.\n" +
                        "\n9. No electronic instrument is to be played throughout the play.\n" +
                        "\n10. No offensive language/ words against any specific person, Indian Constitution, Religion or Caste is allowed during the performance, doing so can result in direct elimination.\n" +
                        "\n11. Each participant should be registered in CULFEST '18, failing which the whole team would be disqualified.\n" +
                        "\n12. The decision of the judge will be binding and final for all and any team violating the rules will be disqualified.\n" +
                        "\n13. The organizing Committee reserves the right to change the venue, time and rules, if desired.\n",
                "1. V. J. S. Praneeth Kumar (9652603041)\n"+
                        "2. Ankita (7635062185)\n",
                "42,000\n",
                "18,000",
                "14,000",
                "10,000"));

        eventList.put("Rangmanch",new EventModel("RANGMANCH",
                "As a chef needs a kitchen, a teacher needs a classroom, an actor needs a theater. A theater is a place where one can show their true acting skills. So this Culfest come and take part in Rangmanch and show the colors of your imagination by creating a new world on the stage Live performers to present the experience of a real or imagined event before . A live audience on a stage through their acting. Rangmanch is a platform to show your acting skills and rule the stage.\n",
                "1. This is a group event. Each team must consist of a minimum of 6 members and maximum of 12 members. Apart from that one person can be there to look after the music or props.\n\n" +
                        "2. Teams can pre-register online or in person There will be only one round of the competition. The maximum time allotted for the play is 25 minutes. This given time is from the empty stage to empty stage.\n\n" +
                        "3. If the play time exceeds the given maximum time i.e.25 minutes, 20% marks per 5 minutes will be deducted from the final marks of the responsible team.\n\n" +
                        "4. The language of the play can be Hindi or English.\n\n" +
                        "5. The performance can also be a musical drama/play. Participants must bring their own music and background tracks they wish to play.\n\n" +
                        "6. Participants must bring their own laptops/PDs for the sound effects and must contact the organizer at least 30 minutes prior to their performance if they wish to play any background tracks during the play.\n\n" +
                        "7. Naked flames/animals/colours and other objectionable objects or things are strictly not allowed in the competition.\n\n" +
                        "8. All the costumes and props are to be arranged by the respective\n\n" +
                        "participating team for their play. They must take care of their own instruments in the green room.\n\n" +
                        "9. Issues like crossing the limits, using abusive language or vulgarity will lead to negative marking and if required, disqualification.\n\n" +
                        "10. The decision of the judges will be final and binding.\n\n" +
                        "11. The organizing team owns all the rights to make any necessary change in the rules if required.\n\n" +
                        "12. Each participant should be registered in CULFEST '18, failing which the whole team would be disqualified.\n\n",
                "1. Leera (7209262295)\n"+
                        "2. Anish (8677939233)\n",
                "26,000",
                "12,000",
                "8,000",
                "6,000"));

        eventList.put("Mime",new EventModel("MIME",
                "\"Action speaks louder than words\". It's not only the voice that an actor can use as a tool for " +
                        "performance, but the whole body to communicate with the audience. Everybody uses mime and gesture in real life, though we don't realize it. It's time to make it a performance technique and\n" +
                        "win exciting prizes. Be a part of culfest 2018's Mime competition and tell your story without actually telling it.\n" +
                        "Mime is the use of movements and gestures in order to express something or tell a story without using speech.\n",
                "1. The team should consist of 1 to 8 members.\n\n" +
                        "2. Time limits for each performance is 4 to 12 mins. The time given is from the empty stage to empty stage.\n\n" +
                        "3. If the play time exceeds the given maximum time, i.e.12 minutes, 10% marks per extra 2 minutes will be deducted from the final marks of the responsible team.\n\n" +
                        "4. No props are allowed.\n\n" +
                        "5. Teams must bring their own music and background tracks they wish to play.\n\n" +
                        "6. Each participant should be registered in CULFEST 18’ failing which, the whole team would be disqualified.\n\n" +
                        "7. Face paint is allowed.\n\n" +
                        "8. The decision of the judge will be binding and final for all and any team violating the rules will be disqualified.\n\n" +
                        "9. The organizing Committee reserves the right to change the venue, time and rules, if desired.\n\n",
                "1. Abhishek (9031819510)\n"+
                        "2. Shristi (7209727245)\n",
                "15,000",
                "7,000",
                "5,000",
                "3,000"));

        eventList.put("Panch Parmeshwar",new EventModel("PANCH PARMESHWAR",
                "Someone said\"Every coin has two sides.\"But panch parmeshwar wants you to prove that you are performing on the right side.\n" +
                        "A problem statement would be given to two groups, performing against to each other. They should justify the situation in front of the panch. So, the panch can give justice to the right group.\n",
                "1. The team should consist of 4 to 5 members.\n\n" +
                        "2. Time limit for preparation is 5 to 10 mins.\n\n" +
                        "3. No props are allowed.\n\n" +
                        "4. Each participant should be registered in CULFEST 18’ failing which, the whole team would be disqualified.\n\n" +
                        "5. A participant can participate in only one team.\n\n" +
                        "6. The decision of the judge will be binding and final for all and any team violating the rules will be disqualified.\n\n" +
                        "7. The organizing Committee reserves the right to change the venue, time and rules, if desired.\n\n" +
                        "8. Issues like crossing the limits, using abusive language or vulgarity will lead to negative marking and if required, disqualification.\n\n",

                "1. Indrani (7654318119)\n"+
                        "2. P.V. Prakash (9494687970)\n",

                "9,000",
                "6,000",
                "3,000",
                "0"));

        eventList.put("Radiance",new EventModel("RADIANCE – THE FASHION SHOW ",
                "Radiance is where the budding fashionistas get to showcase their fashion sense in a way they want here, at NIT JAMSHEDPUR.\nWith the stage all set for innovative designers to leave the audience awestruck with their innovative designs and amazing theme portrayal capabilities, Radiance promises to be a too-good-to-be-true experience for all. Radiance being a capstone event of Culfest at NIT Jamshedpur, gives a glimpse of the professional world of fashion and zips this novice through runway of this glam world. The participating team of various colleges put a glam tag in the event for being fashionable, trendy and creative, all at once. From designing and creating garments to choreographing the moves of models on the ramp with the music, the experience is truly boundless.\nThis year too, Culfest calls all the fashionistas out there, who believe in carrying themselves with the poise, panache and vivacity.\n" +
                        "\n Participants can register from the following link\n\n" +
                        "https://goo.gl/PbLUma" +
                        "\n\n",
                "Prelims\n"+
                        "1. Prelims will be online. Each team will have to send any three photos of previous performances or three portfolio pics of three models at the email id - roshan97offc@gmail.com\n " +
                "\nFinal\n"+
                "1. All the members of the participating team must be registered. \n" +
                        "\n2. There might be a preliminary round, depending on the number of teams participating, for which the teams will have to send portfolio of any 3 models on which they will be judged \n" +
                        "\n3. Number of members in a team should vary between 14 to 20 (minimum 4 male models and 4 female models required) and this number includes the designer, stylists and models on stage. \n" +
                        "\n4. Time limit for performance should be 10 minutes. Additional time of 2 minutes(max) maybe given to each team for prop setup and removal. \n" +
                        "\n5. Each team must give name of a designer. \n" +
                        "\n6. Teams are responsible for their dresses, make-up and background music. Teams are requested to bring their soundtrack in easily transferrable media such as pen-drives. \n" +
                        "\n7. No other members, other than performing members are allowed to come on stage during performance. \n" +
                        "\n8. Vulgarity of any kind would lead to disqualification of team. Use of fire, pets or any hazardous materials are not allowed on stage. \n" +
                        "\n9. If a team fails to stick to the given rules, it will lead to disqualification of the team \n" +
                        "\n10. Only a maximum of 10 members can be present on the stage at any given time, except, for the last 30 seconds. All the team members can be present on stage in the last 30 seconds. \n" +
                        "\n11. Decision of the judge will be binding and final for all and any team violating the rules will be disqualified\n",

                "1. Suraj Suresh (8921446731)\n"+
                        "2. Rahul Meena (9414209985)\n"+
                        "3. Ishani Sarkar (8434002821)\n",
                "70,000\n",
                "32,000",
                "20,000",
                "10,000\n\n" +
                        "Best Designer - 5,000\n" +
                        "Cosplay - 3,000"));

        eventList.put("Creative Writing",new EventModel("CREATIVE WRITING",
                "Writing is an intricate art. It’s not just about putting words on paper but feelings. Culfest’17 brings to you the opportunity to let your creative side overpower your spirit to produce an epitome that mesmerizes others. So if you think you have it in you, come, be a part of this amazing event and write your way to glory !!",
                " 1. Number of Events (2):- English Creative Writing and Hindi Creative Writing\n" +
                        "\n2. It is an Offline Event.\n" +
                        "\n3. Participants will be given 3 -4 topics or audio-visual guides on spot and they have to submit their composition in not more than 400 words for each.\n" +
                        "\n4. The composition may be either in Hindi or in English. Different topics would be given for Hindi and English.\n" +
                        "\n5. The composition can be a piece of prose or story.\n" +
                        "\n6. Plagiarism would lead to disqualification.\n",
                "1. Sunny Shekhar Rathore (9570929581)\n"+
                        "2. Arijit (7005467390)\n",
                "3,000\n",
                "2,000",
                "1,000",
                "0"));

        eventList.put("Potpourri",new EventModel("POTPOURRI",
                "“Potpourri” refers to “a miscellaneous or diverse set of things”. Add to it a spicy twist of literature and voila! You have successfully cooked your way through this extravaganza event. Welcome to the event that has everything for everyone: be it a casual reader solving trivial puzzles, or a lover of the arts taking delight in the romance between language and entertainment. Be prepared for a marathon of word and vocabulary games that test not only your wits but your presence of mind as well in a time pressed environment.\n",
                "1. Number of Events( 2): English Potpourri and Hindi Potpourri\n" +
                        "\n2. Participants are required to participate in teams of 2.\n" +
                        "\n3. Prelims round will be a written round.\n" +
                        "\n4. Teams qualifying the prelims make it to the final rounds\n",
                "1. Nikhil Rai (87977779326)\n"+
                        "2. Sourabh (8651132418)\n"+
                        "3. Rana Dey (9451257953 )\n"+
                        "4. Vishal Jain\n",
                "6,500+6,500\n",
                "3,000+3,000",
                "2,000+2,000",
                "1,500+1,500"));
        eventList.put("JAM",new EventModel("JAM",
                "A-Minute (or JAM) is an all-round-fun event that is all about the control of the mind over the mouth. Can you make it through sixty seconds of non-stop talking without hesitation, repetition, or deviation? Or will the sheer pressure make you crumble and have your competitors pounce on you in an instant? It is a fun filled literary event where the participants have to speak on the given topic for a maximum of 1 minute. While speaking, they cannot make certain errors. If any one of the fellow participant spots an error while participant is speaking, he/she can clap and point out the error for which they will be rewarded points. Points are also awarded for the time span for which a participant speaks. So fill that unforgiving minute with sixty seconds worth of impeccable English and you would be the winner.\n",
                "1. The errors which will be considered are-\n\n" +
                        "Plagiarism\n" +
                        "Queen’s English\n" +
                        "Standard format\n" +
                        "Late start\n" +
                        "Early start\n" +
                        "Gesticulation\n" +
                        "Over dramatization\n" +
                        "Post qualification\n" +
                        "Beating around the bush\n" +
                        "Grammatical error\n",
                "1. Atul (8271773445)\n"+
                        "2. Abhishek (8084129867 )\n",
                "4,500\n",
                "2,400",
                "1,400",
                "700"));

        eventList.put("Journalism",new EventModel("JOURNALISM",
                "Anybody can be a journalist. There are opportunities for all of us to contribute to stories If you're an intellectually curious person— let's assume that you are—you are likely to have embraced a number of notions about how the world works, how it should work and who should be running it. There should be no strings attached to your opinions, no one asking you to tone it down, and nobody that really wishes you to just shut the hell up and report just the fluffy pieces. You should also lack the warm and fuzzy attitude of your naysayers (and the trolls) who are always right when they spout off at the mouth in the comment section or on social media. \n In the age of the internet and social media, what does it mean to be a journalist? What is journalism?\n" +
                        "\n1 Getting accurate information fast  And treating it skeptically.\n" +
                        "\n2 Getting accurate information fast  And treating it skeptically.\n" +
                        "\n3 Doing it carefully, properly and ethically.\n" +
                        "\n4 No matter what the medium.",
                "There will be two rounds in Journalism: Prelims and Finals. A maximum of 8 teams will be shortlisted for the finals.\n" +
                        "\nPrelims – \n" +
                        "\n1 A minimum of 2 and maximum of 3 members are allowed in the team. \n" +
                        "\n2 All the teams have to submit a write-up as their Prelims entry. Word limit is 250 words\n" +
                        "\n3 The abstract must be mailed to lds1968nitjsr@gmail.com by 13th February(12 noon).\n" +
                        "\n4 The write up can be either in Hindi or English. You will have to stick to one language throughout the competition, i.e. if you get selected for the finals, the reporting has to be done in the language you chose in prelims.\n\n" +
                        "\nFinals – \n" +
                        "\n1 Any team member should not be replaced.\n" +
                        "\n2 The mode of communication/reporting has to be the same as that chosen in Prelims.\n" +
                        "\n3 Every team will be allotted the equipment for 30 minutes each day\n" +
                        "\n4 The events to be covered shall be chosen by the team.\n" +
                        "\n5 The teams need to cover the festival in a way that they may find suitable. They may take interviews as well and/or report about the ongoing events.\n" +
                        "\n6 The reporting has to be done of the events taking place between 9am-5pm. Main-stage reporting is not allowed\n" +
                        "\n7 All the video clippings, separated day wise must be submitted to the coordinator before 6 pm on 19th feb. Basic video editing is allowed. \n" +
                        "\n8 The camera will be allotted to the teams in the respective slots provided to them. Teams are requested to report on time. Any excuse for the delay will not be entertained.\n" +
                        "\n9 The finals entry should include video clippings plus a proper report covering the 3 days activities.\n" +
                        "\n10 No obscenity and no inappropriate behavior will be entertained in the video. \n" +
                        "\n11 The equipment must be handled carefully. Any damage caused to the equipment will be penalized\n" +
                        "\nDecision of the judge will be binding and final for all and any team violating the rules will be disqualified.",
                "1. Tanya Omar ( 7273872054 )\n"+
                        "2. Aditya Sanket (9473439892)\n",
                "18,000\n",
                "9,000",
                "6,000",
                "3,000"));

        eventList.put("Policy Debate",new EventModel("POLICY  DEBATE",
                "It is better to debate a question without settling it than to settle a question without debating it”.\n While the pen might be mightier than the sword, it is observed that when words get a tongue they shake mountains. So Mademoiselles and Messieurs, here’s your opportunity to move mountains with your thoughts and ideas. Iron out the kinks in your throat as you prepare to shine on stage with the only armory being your voice.\n Protect your opinion when the war is waged; it might as well be the only thing by your side. Confound your opponents and convince your audience. If you think stage-fright could get the better of you, overpower it with your confidence.\n The greatest battle of words and wits is here.\n",
                "Prelims -\n"+
                        "\n1. The participants need to form a team of two members. Single person entry will be disqualified.\n" +
                        "\n2. An abstract must be submitted on the given topic for preliminary screening. The topic will be notified later.\n" +
                        "\n3. The length of the abstract must not exceed 400 words.\n" +
                        "\n4. The contact details must be properly mentioned.\n" +
                        "\n5. The abstract must be mailed to lds1968nitjsr@gmail.com\n"+
                        "\nFinals - \n" +
                        "\n1. In the finals, each team will be competing against one another for a total sum of 12 minutes.\n" +
                        "\n2. Each pair of teams will be given a separate topic.\n" +
                        "\n3. The organizers will be deciding which team will be for or against the motion. The decision will be binding.\n" +
                        "\n4. Of the total time allotted the time division will be as follows:-\n" +
                        "  Participant A, Team 1: 3 minutes. \n" +
                        "  Participant A, Team 2: 3 minutes. \n" +
                        "  Participant B, Team 1: 3 minutes. \n" +
                        "  Participant B, Team 2: 3 minutes. \n" +
                        "  Rebuttal: 3 minutes.\n" +
                        "\n5. Rebuttal can come from the judges, opponent teams or the audience.\n",
                "1. Rohit Kumar (8092291457)\n"+
                        "2. Arjun (9825113966)\n",
                "9,000\n",
                "4,000",
                "3,000",
                "2,000"));

        eventList.put("Poetry Slam",new EventModel("POETRY SLAM",
                "Poetry is the unexplored ocean that many fear to set sail on, clinging on to the safety of the calm harbor. But that’s not who ships are built for. Aboard the stage with hundreds of poets as they embark on a poetic journey against the crashing waves, and continue until you’re the last one standing. All forms of storytelling, songwriting, stand-up comedy and cold hard poetry are welcome.\n",
                "1. Poems can be on any subject and in any style but must be original.\n" +
                        "\n2. Use of props, special costumes, musical instruments or pre-recorded music is not allowed.\n" +
                        "\n3. This is an individual event and is open to all.\n" +
                        "\n4. Poems once performed may not be repeated in further rounds, except in case of tie-breaking rounds, violation of which disqualifies the poet. Therefore each poet should plan on bringing at least 3 original poems to compete, with an extra poem as buffer for a tie.\n" +
                        "\n5. Time limit is three minutes. After three minutes, there is a 10-second grace period after which a penalty of 0.5 is automatically deducted, without warning, from each poet’s overall score for every subsequent ten seconds.\n" +
                        "\n6. The judges will give each poem a score from 0 to 10.\n" +
                        "\n7. The total score for a poet will be the sum of the scores by all the judges in the panel for a particular round and will be considered for their qualification to next round.\n",
                "1. Rolee Agrawal (7903456035)\n"+
                        "2. Riya (7209772585)\n",
                "4,500\n",
                "2,400",
                "1,400",
                "7,000"));
        eventList.put("Wit-a-Story",new EventModel("WIT-A-STORY",
                " A event where there is no correct answer. Wit-a-story is event which will demand you to craft witty and quirky answers to the most outrageous questions out there. Be ready to scratch your grey cells and let your pen reflect your creativity. ",
                "1. A team should consist of two members.\n" +
                        "\n2. A total of 6 teams will be selected for the finals. \n" +
                        "\n3. A written prelim will be conducted to select the finalists.\n",
                "1. Aditya Sanket (9473439892)\n" +
                        "2. Alok Jha (8809638588)\n",
                "4,000","2,500","1,500",""));
        eventList.put("SSMQ",new EventModel("SSMQ",
                "“ Trust yourself, you know more than you think you do”.\n" +
                        "Culfest’18 brings to you the mother of all quizzes-the SSMQ- with questions from every topic under the sun. Be sure to exercise your brain to its limit and surprise many, including yourself. This is where the best minds compete for glory. It’s not just about knowledge, but also about thinking differently, getting the timing right, and of course, having a little bit of luck on your side! \n"+
                        "So if you think you’ve got what it takes to make a mark, then do come and be a part of this grand event.\n",
                "1. A team should consist of 2 members.\n" +
                        "\n2. There will be total 8 teams in the Onsite Finals.\n" +
                        "\n3. A written prelims round will be conducted to select the top 6 teams for the finals. \n"+
                        "\n4. Decision of the quiz master will be binding and final for all and any team violating the rules will be disqualified.\n",
                "1. Ashutosh (8987717520)\n"+
                        "2. Shubham (9155677552) + Tanya Omar (8299761998)\n",
                "9,000\n",
                "4,000",
                "3,000",
                "2,000"));

        eventList.put("Theme Quiz",new EventModel("The “Tryst with Telly” quiz",
                "In line with the theme \"Tryst with Telly\" - an entertainment quiz focusing on TV series, animes and anything and everything related to telly.",
                "1. Team size – 2 members\n" +
                        "\n2. Inter-college teams are not allowed.\n" +
                        "\n3. Rest of the rules will be described during the quiz.\n",
                "1. Jayant Kumar (7549088075)\n"+
                        "2. Rajeev (9801045837)\n",
                "15,000\n",
                "7,000",
                "5,000",
                "3,000"));

        eventList.put("India Quiz",new EventModel("Jashn-e-India quiz",
                "A quiz centered around India. Encompassing everything\n" +
                        "from culture to cuisine, from history to geography, from politics to art\n" +
                        "forms. Celebrating India. Celebrating Indians. \n",
                "1. Team size – 2 members\n" +
                        "\n2. Cross college and cross school teams are allowed. For cross- college teams both members must be enrolled in full time courses. For cross school teams both members must be school students.\n" +
                        "\n3 Note that both members must be individually registered for culfest before attempting any quiz. Unregistered participants won't be considered in the finals.\n" +
                        "\n4. Rest of the rules will be described during the quiz.\n",
                "1. Saurabh Singh (8210901138)\n"+
                        "2. Saumya (7739135255)\n",
                "9,000\n",
                "4,000",
                "3,000",
                "2,000"));
        eventList.put("Biztech Quiz",new EventModel("BizTech quiz",
                "An appetizer for Geeks and Biz wizards with a knack for trivia. A completely biz and tech centred quiz to test your mettle.\n",
                "1. Team size – 2 members\n" +
                        "\n2. Cross college and cross school teams are allowed. For cross- college teams both members must be enrolled in full time courses. For cross school teams both members must be school students.\n" +
                        "\n3 Note that both members must be individually registered for culfest before attempting any quiz. Unregistered participants won't be considered in the finals.\n" +
                        "\n4. Rest of the rules will be described during the quiz.\n",
                "1. Ritu Raj (9006299179)\n"+
                        "2. Kartikeya Patwardhan (9572894744)\n",
                "9,000\n",
                "4,000",
                "3,000",
                "2,000"));

        eventList.put("Slamies",new EventModel("SLAMies",
                "SLAM expands to Sports, Literature, Art and Music. These metrics form an important part of a cultural heritage. So join us as we celebrate Global culture through SLAM quiz this Culfest. \n",
                "1. Team size – 2 members\n" +
                        "\n2. Cross college and cross school teams are allowed. For cross- college teams both members must be enrolled in full time courses. For cross school teams both members must be school students.\n" +
                        "\n3 Note that both members must be individually registered for culfest before attempting any quiz. Unregistered participants won't be considered in the finals.\n" +
                        "\n4. Rest of the rules will be described during the quiz.\n",
                  "1. Akash Singh (7004549336)\n"+
                        "2. Ujjwal (9798331281)\n",
                "9,000\n",
                "4,000",
                "3,000",
                "2,000"));

        eventList.put("Culfest Idol",new EventModel("CULFEST IDOL",
                "Admirer of the rich folk culture and music? Don’t feel lost in this rock and jazz buzzing western environment because here is your chance to win the day. Participate in this event and tune the audience to your strings. Give everyone a glimpse of the Kishore da or the Lata Mangeshkar hidden in you.\n",
                "Prelims -\n" +
                        "1. Participants can sing eastern songs of any genre (preferably Hindi).\n" +
                        "\n2. Maximum time allotted is 3 minutes.\n" +
                        "\n3. Participants should bring the karaoke tracks of their songs. However, it is optional for the prelims round.\n" +
                        "\n4. Participants can perform only with or without karaoke in prelims round. No instruments are allowed.\n" +
                        "\n5. Marks shall be deducted if time limit is exceeded.\n" +
                        "\nFinals -\n" +
                        "\n1. The participants, selected in the prelims round, will move on to the finals where they will have to come prepared with a different song of their choice.\n" +
                        "\n2. They will need to carry proper karaoke tracks for their performances (compulsory).\n" +
                        "\n3. The time limit should not exceed 5 minutes for each performance.\n" +
                        "\n4. Marks will be deducted for exceeding the time limit.\n" +
                        "\n5. The decision of the judges will be final and binding.\n",
                "1. Pitan(9088967470)\n"+
                        "2. Kshitij(9525686834)\n",
                "4,800\n",
                "2,500",
                "1,500",
                "800"));

        eventList.put("The Voice",new EventModel("THE VOICE",
                "“Ah! Music, a magic beyond all we do here”, says Dumbledore in Harry Potter & the Philosopher’s Stone.\n" +
                        "Music knows no boundary. It moves people of all culture, language and origin. Music is freedom. This Culfest’18, come and manumit yourself with the world ruled by the likes of Madonna, Eminem, Taylor Swift and others. Western Vocals is a solo singing competition. Participants will be judged on their vocal skills, performance and the choice of song among other criterions. A participant may or may not include karaoke in their songs.\n",
                "Prelims -\n" +
                        "\n1. This competition is open to any western jam based individual performance.\n" +
                        "\n2. Participants are required to get their own karaoke tracks to accompany them in their songs. (Optional for prelims round).\n" +
                        "\n3. Participants can perform only with or without karaoke in prelims round. No instruments are allowed.\n" +
                        "\n4. Time limit should not exceed 5 minutes for each performance.\n" +
                        "\nFinals -\n" +
                        "\n1. Participants selected in the Prelims round will move on to the finals where they have to come prepared with a different song of their choice.\n" +
                        "\n2. They need to carry proper karaoke tracks for their performances (compulsory).\n" +
                        "\n3. Participants are allowed to sing along while playing their own instrument(s) but only their singing will be taken into account for judgement.\n" +
                        "\n4. Time limit should not exceed 5 minutes for each performance.\n" +
                        "\n5. Marks will be deducted for exceeding the time limit. 6. The decision of the judges will be final and binding.\n",
                "1. Manish(8757555614)\n"+
                        "2. Rishabh(9327526244)\n",
                "4,800\n",
                "2,500",
                "1,500",
                "800"));

        eventList.put("Duets",new EventModel("DUETS",
                "To sing a duet means to share with someone both the pleasure and responsibility of making music. One skillful singer on stage is great, but two soloists performing can be quirky, romantic and a treat to the senses. CULFEST’18 brings you the opportunity to perform a duet and create a melody like never before. Be it a sweet mesmerizing ghazal or a scintillating bright qawwali; be it folk or filmi; in a nutshell be it any genre of music; you can showcase your song on our platform. So, here's a chance to prove yourself, say the Bobbsey's twins, birds of a feather or peas in a pod of euphonic music, provide a treat to the ears of the audience and reach the zenith to win the event!",
                "Prelims - \n" +
                        "\n1. The participating teams will be judged on their co-ordination, presentation, distribution of lyrics and their ‘surtaal’\n" +
                        "\n2. Two Participants (girl-girl/boy-boy/girl-boy) are required to give a performance together.\n" +
                        "\n3. You should bring the karaoke tracks for your songs.(optional for prelims)\n" +
                        "\n4. Maximum time limit is 5 minutes per performance.\n"+
                        "\nFinals - \n" +
                        "\n1. Selected participants will move on to the final round where they have to sing a different song of their choice.\n" +
                        "\n2. Maximum time limit is 7 minutes per performance.\n" +
                        "\n3. Karaoke tracks are compulsory.\n" +
                        "\n4. Musical Instruments are NOT ALLOWED.\n" +
                        "\n5. The decision of the judges will be final and binding.\n",
                "1. Sonal(9431323480)\n"+
                        "2. Anukul(9955048759)\n",
                "9,000\n",
                "4,000",
                "3,000",
                "2,000"));

        eventList.put("Pitch Perfect",new EventModel("PITCH PERFECT",
                "Music is the last true voice of the human spirit. It can go beyond language, beyond age, and beyond color straight to the mind and heart of all people. Saying that, what about an artistic blend of such voices? Ever dreamt of being part of an ensemble? Culfest 18 gives you a chance to captivate the audience with profound renditions by bringing together Indian and western music in your soul rending fusion performances along with your mellifluous mates and symphonious sidekicks. The unrivalled platform has been the launch pad of myriad of fresh musical talents and is perfect for those itching to show their vocal skills. So this Culfest, belt out songs of any genre and harmonize your way to the top, winning cash prizes and more.\n",
                "1. A team should have 4-8 members(including Vocals and instrumentals).\n" +
                        "\n2. Participants can sing any song or mashup preferably Hindi or English.\n" +
                        "\n3. Time limit for each group is 7 minutes.\n" +
                        "\n4. Electric instruments like keyboard, electric guitar etc. are not allowed. Drums are not allowed as well. However, participants are allowed to use acoustic guitar.\n" +
                        "\n5. Use of karaoke is not allowed at any point.\n" +
                        "\n6. Participants may use their creativity (“jugaad”) by using household things (non electrical) which can produce sound beats. You can tap, snap, clap, rap and harmonize.\n" +
                        "\n7. Participants should bring everything required for their performance beforehand.\n" +
                        "\n8. Marks shall be deducted if time limit is exceeded or for violation of any rule. The decision of the judges will be final and binding.\n",
                "1. Bharti(7301105795)\n"+
                        "2. Akshat Mittal(7879345617)\n",
                "15,000\n",
                "7,000",
                "5,000",
                "3,000"));

        eventList.put("Unplugged",new EventModel("UNPLUGGED",
                "And the night shall be filled with music, \n" +
                        "And the cares that infest the day, \n" +
                        "Shall fold their tents like the Arabs, \n" +
                        "And as silently steal away.\n\n" +
                        "Music is peace, thought, wisdom. Music is forever. If music soothes and softens your soul as well, if you are gifted with melodious voice and skilfully plays any musical instrument as well, then Unplugged is the perfect platform for you. Unplugged is a solo competition in Culfest’18. Let your voice and instrument do the magic and mesmerise everyone.\n",
                "\n1. Participants can sing any song of any language and genre with an instrument(instrument is compulsory) or can perform musical piece on an instrument.\n" +
                        "\n2. Maximum time limit: 5 minutes.\n" +
                        "\n3. Participants should bring the instrument required for their performance.( karaoke not allowed).\n" +
                        "\n4. Participants are allowed to play along with their own instruments. Their singing and instrumentation skills will be taken into account for judgement. If any participant is performing only on instrument then the judging criteria will be solely based on instrumental skills.\n" +
                        "\n5. Marks shall be deducted if time limit is exceeded or for violation of any rule. The decision of judges will be final and binding.\n" +
                        "\n6. The judges will critique the contestant’s performance based on the choice of song, presentation, vocal and instrumentation skills.\n" +
                        "\n7. Performer needs to perform using a single instrument.\n",

                "1. Jahanwi(9097297738)\n"+
                        "2. Somnath Mirdha(8294725174)",
                "4,000\n",
                "2,500",
                "1,500",
                "0"));

        eventList.put("Battle Of Bands",new EventModel("BATTLE OF BANDS",
                "“The true beauty of music is that it connects people. It carries a message, and we, the musicians, are the messengers.” - Ron Ayers\n" +
                        "If you have a message that can stir the mass into unison, wait no more because Culfest’18 brings you, just the dais you need. Battle of Band provides you with the opportunity of presenting your own idea of band music and, displaying your talent like never before. Let the audience have a taste of your creation and leave them craving for more. Practice like you have never won. Perform like you have never lost. Don’t keep calm, set the stage on fire and the crowd up roaring. Note: Register before 12th February for this event. A maximum of 10 teams are allowed.\n" +
                        "\n Participants can register from the following link\n\n" +
                        "https://goo.gl/PbLUma" +
                        "\n\n",
                "Prelims -\n" +
                        "\n1. The band must have a minimum of 3 members and a maximum of 8 members.\n" +
                        "\n2. The time limit for the performance, including the time allotted for sound check, is 15 minutes(Stage in & Stage out).\n" +
                        "\n3. The teams are free to perform 2 songs (One English + One Hindi/Regional).\n" +
                        "\n4. Note: Language is not a constraint for music. Songs in English, Hindi or any other regional language are most welcomed. Versatility will give you extra edge over your opponents.\n" +
                        "\n5. The band must have at least one guitarist, one bassist and a drummer.\n" +
                        "\n6. Decision of the judges will be final and binding.\n" +
                        "\nFinals -\n" +
                        "\n1. The band must have a minimum of 3 members and a maximum of 8 members.\n" +
                        "\n2. The time limit for the performance, including the time allotted for sound check, is 25 minutes. Negative Marking will be there for exceeding time limit.\n" +
                        "\n3. The teams must perform 3 songs: Two Original Composition and One Cover of any eastern/western song.\n" +
                        "\n4. The band must have at least one guitarist, one bassist and a drummer.\n" +
                        "\n5. Decision of the judge will be final and any team violating the rules will be disqualified.\n",
                "1. Bhomesh(8826065692)\n"+
                        "2. Sushanto(9955510098)\n"+
                        "3. Yatharth(7481800562)\n",
                "36,000\n",
                "15,000",
                "12,000",
                "9,000"));
        eventList.put("Instant-o-graphy",new EventModel("Instant-o-graphy",
                "Do you have an eye for something exceptional in the wildest of the places or to capture your vision in a frame and show it to the World? If you're willing to explore your passion for Photography and are ready for a challenge, this Event is for you. With 36-hours in your hands, the clock is ticking while you struggle to bring your imagination to life and compete for the best.\n",
                "1. There is no Prelims round for entry into the contest. \n" +
                        "\n2. This is a solo/team event. The team can have a maximum of 2 members. \n" +
                        "\n3. The photographs are to be taken relevant to the theme which will be provided to you in the campus, at VSG arena, during 10:00 am-12:00 pm on 16th Feb,2018. \n" +
                        "\n4. [Three] themes have to be chosen at random, out of which [two] are to be selected by a team. \n" +
                        "\n5. The photographs must be taken during the Culfest period and they must contain proper EXIF data (date/time on which the photo was taken, embedded in the file). \n" +
                        "\n6. General Image Retouching (adjustments of Exposure, Contrast, Cropping, etc.) and Color Correction is permitted. \n" +
                        "\n7. Image Manipulation as Graphic-Alteration is not allowed. \n" +
                        "\n8. Submission Deadline: 11:59 pm on 17th Feb,2018. \n" +
                        "\n9. The Results are most likely to be announced on 18th Feb, 2018 on the Culfest's Facebook Page. \n",
                "1. Monu Kumar (8603788210)\n"+
                        "2. Shambhavi\n",
                "2,500\n",
                "1,500",
                "1,000",
                "0"));

        eventList.put("48-hours",new EventModel("48-hours",
                "You are a Youtube Star with 10.9M followers. You just tweeted on what video should you make next. The fans poured in a few of the suggestions and You pick up the top re-tweeted suggestion. You post videos every Friday and it's already Wednesday. Hurry Up! You've just got 48 hours for the fan requests. As a Youtuber, your fans are everything, every single penny you earn through adsense is the sincerity you have put in your works. The better the content, the larger your fandom grows! So, get-on with your ideas! Tick-Tock! Tick-Tock! \n",
                "1. There is no Prelims round for entry into this contest. \n" +
                        "\n2. This is a team event. The team can have a maximum representation of 3 members. \n" +
                        "\n3. The themes shall be posted on the Facebook Page/Website of Culfest at 10:00 am on 16th Feb, 2018. \n" +
                        "\n4. The video must be submitted at 10:00 am on 18th Feb, 2018. \n" +
                        "\n5. Use of DSLRs for recording the videos should be preferred, but a better quality smartphone camera is also recommended. \n" +
                        "\n6. Genre of the video shall be based on your own interpretations. \n" +
                        "\n7. The video should include the Team Name and the Title as the opening credits. \n" +
                        "\n8. Video length limit is 5 minutes including credits. \n",
                "1. Pratik Sinha (9661946944)\n"+
                        "2. Purushottam (9097784035)\n",

                "5,000\n",
                "3,000",
                "2,000",
                "0"));

        eventList.put("Foot Loose",new EventModel("Foot Loose",
                                                    "“Great dancers are not great because of their technique; it’s because of their passion. ”Do you  think you have it in you what it takes to do the locking and popping of be-Boer?Or you consider yourself more of a free styler?It doesn’t matter if you are a jazz dancer or a \"chak de phate\" bhangda specialist. Put your dancing shoes and compete in the solo dance competition to prove that you are a connoisseur when it comes to grooving to the beats.\n",
                                                    "1. The competition takes place in two rounds ,the Prelims and the Finals. \n" +
                                                            "\n2. Dance form can be either classical or freestyle. \n" +
                                                            "\n3. Props can fetch extra points. \n" +
                                                            "\n4. Live music is not allowed. \n" +
                                                            "\n5. The music to be used must be submitted to the organizers in .mp3 format atleast 1 Hour before the event begins. \n" +
                                                            "\n" +
                                                            "PRELIMS\n" +
                                                            "\n" +
                                                            "1. The participants must showcase demo of their performance for the Final Round. \n" +
                                                            "\n2. The duration of the performance should be 2-3 minutes. \n" +
                                                            "\n3. Props are allowed ,but will NOT fetch points during this round. \n" +
                                                            "\n" +
                                                            "FINALS\n" +
                                                            "1. The performance time for each participant is 3-5 minutes. \n" +
                                                            "\n2. Song should be a mixture of minimum two songs. \n" +
                                                            "\n3. The creative use of props is allowed in this round , and they do fetch points in this round. \n" +
                                                            "\n4. Vulgarity of any form wil not be allowed in the competition and can lead to immediate disqualification. \n",
                                                            "1. L. Suresh (9032328270)\n"+
                                                                "2. Kanishka (7277181420)",
                                                            "4,800\n",
                                                                "2,500",
                                                                "1,500",
                                                                    "800"));


        eventList.put("Dancing Duo",new EventModel("Dancing Duo",
                                                        "'“It is with your feet that you move. But it is with your heart that you dance.” This competition Gives you the perfect opportunity to shake your booty with your buddy. If you have steaming hot  chemistry and mellow synchronization then dress classy and dance cheesy with your partner and set the stage on fire. Dance before the music is over. Live before your life is over.\n",
                                                        "The competition takes place in a single round. However, if participation is large then a prelims round will be added in which the participants have to perform apart of their performance.\n" +
                                                                "1. The couple has to perform on aself –chosen song. \n" +
                                                                "\n2. The time limit is 3-5 minutes. \n" +
                                                                "\n3. Classical dance forms will not be allowed. \n" +
                                                                "\n4. Props can fetch extra points. \n" +
                                                                "\n5. Two individuals of the opposite gender or same gender can pair up to compete in this event. \n" +
                                                                "\n6. Live music is not allowed. \n" +
                                                                "\n7. The music to be used must be submitted to the organizers in.mp3 format atleast 1 Hour before the event begins.\n",
                                                                "Nimisha Mishra (8736994289 )\n"+
                                                                    "K. Shailaja (8919276121)\n",
                                                                    "9,000\n",
                                                                        "4,000",
                                                                    "3,000",
                                                                    "2,000"));
        eventList.put("Shake On Beat",new EventModel("Shake On Beat",
                                            "\"To dance is to be out of yourself. Larger, more beautiful ,more powerful \" If you think you have That \"dance ka keeda\" in you, this stage awaits your ‘dhamekdaar’ entry. Be it classical, contemporary, hiphop or the likes; if you think you can dance any time,anywhere,in any dance form come show us what you got and set the stage ablaze with your dance moves in one of the most exciting and fun-filed events of Culfest-18!\n",
                                           "PRELIMS \n" +
                                                   "\n1. A group off our participants are formed randomly and they have to dance for random music played on the spot. \n" +
                                                   "\n2. Best two off our participants will be finalized for final round from each group. \n" +
                                                   "\n" +
                                                   "FINALS\n" +
                                                   "\n1. Groups off our participants are formed randomly from the final lists and they have to dance for random music played on the spot. \n" +
                                                   "\n2. Instant choreographic skills and synchronization to music fetches more points. \n",
                                                "1. Raj Sanchu (7765053518)\n"+
                                                "2. Anupriya Rani ( 7250703758)\n",
                                                    "4,800\n",
                                                    "2,500",
                                                    "1,500",
                                                        "800"));

        eventList.put("Choreo Night",new EventModel("Choreo Night",
                "Synchronize your steps to the 'Beat', act your costumes to represent your character and who Knows you might land on a bounty .Come this culfest’18 and show your team work to win hearts This gala event promises to give you life long memories.\n" +
                        "\n Participants can register from the following link\n\n" +
                        "https://goo.gl/PbLUma" +
                        "\n\n",
                "1. Dance performance can/cannot be a THEME based (no extra points for THEME). \n" +
                        "\n2. Teams may consist of a minimum of 7 and a maximum of 25 members (minimum of 4 BOYS/GIRLS in the participating team). \n" +
                        "\n3. A minimum of 5 and a maximum of 17 members must be present on stage at any given moment. \n" +
                        "\n4. The music and the list of group members must be submitted to the organizers at least 1 Hour before the start of the event .The name of the submitted audio file should be same as the name of the team and must be in .mp3 format. \n" +
                        "\n5. Performance duration in this round should preferably lie between 7-10 minutes. Marks will be deducted for exceeding the time limit. \n" +
                        "\n6. The music should be a mixture of minimum 4 songs . Any pre-recorded or live music can be used for the performance. \n" +
                        "\n7. Innovations such as props fetch extra points in this round. \n" +
                        "\n8. Props will have to be arranged by the participants themselves .A prop is any thing which is not worn on the body as a part of the costume,for example a hand-held hat, stick, bal or any piece of costume that is removed during the routine. \n" +
                        "\n9. Props which require electricity or are considered hazardous(such as fire ,smoke ,fog devices, knives etc.) are not allowed .Throwing confetti ,gliter ,chalkpowder etc. during the performance are  also discouraged. The props must come on during the performance and must not require extensive setup. \n" +
                        "\n10. The team should be punctual. Any team that’s not ready by the specified time may be disqualified. \n" +
                        "\n11. If the lighting facility is to be availed, one person of the group can supervise the lighting during the performance. Otherwise it would be taken care of by the Lights and Sounds group of the organizing team. Creativity and innovation will fetch extra points. \n" +
                        "\n12. Vulgarity of any form will not be allowed in the competition and can lead to immediate disqualification. \n" +
                        "\n13. Dimensions of the stage/performance area will be uploaded on our website very soon. \n",
                                "1. Gopal agarwal (9955268864)\n"+
                                "2. Dinesh Kondra ( 9100203066)\n"+
                                "3. D. Bhargav (7989756275)\n",
                                    "42,000\n",
                                    "22,000",
                                    "12,000",
                                    "8,000"
                        )   );

        eventList.put("FaceOff",new EventModel("FaceOff",
                                                "Street Dancing is an activity to do when you are bored . Dancesthat developed outside of the studio setting and in a social space like streets , clubs and parks .Team of three participants compete with another team of three participants. This involves direct individual competition.\n",
                                                "Team must consist of at least one opposite gender. \n" +
                                                        "\nSongs will be provided to each team 2-minutes just before the performance. \n",
                                                "Siney Prasad (9112102404)\n"+
                                                        "Saloni seth (7800780655)\n",
                                                    "10,000\n",
                                                        "4,500",
                                                            "3,500",
                                                        "2,000"
                                                        ));

        eventList.put("Ludo",new EventModel("Ludo",
                                                    "Bored of playing board games sitting in a room, let's enjoy then with your friends on a phone. So come play and a dice decide your fate.\n",
                                                    "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                                                                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));

        eventList.put("Be The Bean",new EventModel("Be The Bean",
                                                "With the power of speech detained,let your character built up speak...When you embark your acting and guessing skills\nCome be a part of Dumbc",
                                                    "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));

        eventList.put("Blind Date",new EventModel("Blind Date",
                                                        "All the guys and gals there, with the Valentine's week approaching... You all must be searching for a partner... So, here we have something interesting for you all... \"BLIND DATE\". Come and start your hunt for the most suitable date...!",
                                                            "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));
        eventList.put("Henna",new EventModel("Henna",
                                                        "Mehendi...Indian festivals are almost incomplete without this special ingredient. And, that's when the artist in us wakes up suddenly... So, all the people out there, show your creativity in this new event \"HENNA\".",
                                                    "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));
        eventList.put("Antakshari",new EventModel("Antakshari",
                                                        "From Ed Sheeran to Arijit Singh...\n" +
                                                                "From Justin Bieber to Atif Aslam... \n" +
                                                                "Everyone is fair coz this is Antakshari... So, people show your love for songs, music and the lyrics too... The \"ANTAKSHARI\" is awaiting you...!",
                                                        "Legen--wait for it--dary!!","Sankalp Kurli: \n9006141404\n"+
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));
        eventList.put("House Of Cards",new EventModel("House Of Cards",
                                                        "A game of cards which will tickle your skills to plan and win. Just like the TV series, you need to plan, execute, and lead yourself to victory.",
                                                            "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));


        eventList.put("Big Boss",new EventModel("Big Boss",
                                                "Wanna look like your favourite character...?\n" +
                                                        "Then, We have the perfect platform for you... \"BIG BOSS\". Just Copy the best you think you can be and the whole event will be yours...!",
                                            "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));
        eventList.put("KBF",new EventModel("KBF",
                                                "KBC... Everyone here are aware of this superhit show... But here, let us introduce you all to \"KBF\"... Let's see how much you know about telly world.... Bring out the wiki in you..!",
                                            "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","","" ));

        eventList.put("Blind Fold",new EventModel("Blind Fold",
                                                        "All of us have enjoyed this game in our childhood... It is something which remind us of our school days... Now introducing a new kind of \"BLIND FOLD\". Come and discover... It's all a mystery here...!",
                                                    "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));

        eventList.put("Pillow Fight",new EventModel("Pillow Fight",
                                                        "Remeber those transient fights with your siblings on vacations ?? \n" +
                                                                "Yes a nostalgic feeling .. team culfest brings you a chance to relive the nostalgia .. come hit as hard as you can with the event Pillow Fight",
                                                            "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100  8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));
        eventList.put("Paper Dance",new EventModel("Paper Dance",
                                                "With perfect ed sheeran music setting up the mood its time to pick your love as close as you can ... balance is the chemistry behind a health bond .. it your time to test urs... here we give u “Paper Dance”",
                                                "Legen--wait for it--dary!!","Ekansh Gupta:\n8394912100\n8919301097\n" +
                "Sundeep Kss:\n8142127781  8309971303\n","To be announced later.","","",""));


        EventModel current=eventList.get(event);
        cardTitle.setText("DESCRIPTION");
        cardTitle.setTypeface(typeface1);
        cardText.setText(current.getDescription());
        cardText.setTypeface(typeface2);








        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                EventModel current=eventList.get(event);

                switch(item.getItemId())
                {

                    case R.id.description:
                        cardTitle.setText("DESCRIPTION");
                        cardText.setText(current.getDescription());
                      //  cardText.setMovementMethod(LinkMovementMethod.getInstance());
                        cardTitle.setTypeface(typeface1);
                        cardText.setTypeface(typeface2);
                        break;



                    case R.id.rules:
                        cardTitle.setText("RULES");
                       cardText.setText(current.getRules());
                        cardTitle.setTypeface(typeface1);
                        cardText.setTypeface(typeface2);
                        break;



                    case R.id.coordinator:
                        cardTitle.setText("COORDINATORS");
                        cardText.setText(current.getCordinators());
                        cardTitle.setTypeface(typeface1);
                        cardText.setTypeface(typeface2);
                        break;


                    case R.id.prizes:
                        cardTitle.setText("PRIZES");
                        cardText.setText("Total Prize : "+current.getTotalprize()+"\nFirst Prize :"+current.getFirstPrize()+"\nSecond Prize :"+current.getSecondPrize()+"\nThird Prize : "+current.getThirdPrize());
                        cardTitle.setTypeface(typeface1);
                        cardText.setTypeface(typeface2);
                        break;

                }



                return true;
            }
        });





    }


    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {

        BottomNavigationMenuView menuView=(BottomNavigationMenuView) view.getChildAt(0);

        try{
            Field shiftingMode=menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView,false);
            shiftingMode.setAccessible(false);

            for(int i=0;i<menuView.getChildCount();i++){
                BottomNavigationItemView item=(BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }



        }catch(NoSuchFieldException e){
            Log.e("BNVHelper","Unable to get shift mode field",e);

        }catch(IllegalAccessException e){

            Log.e("BNVHelper","Unable to change value of shift mode",e);
        }

    }




}
