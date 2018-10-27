package jamshedpur.nit.culfest.com.culfest17.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jamshedpur.nit.culfest.com.culfest17.Adapter.CustomExpandableListAdapter;
import jamshedpur.nit.culfest.com.culfest17.R;
import jamshedpur.nit.culfest.com.culfest17.Widget.ExpandableListDataPump;

public class MapLocationActivity extends AppCompatActivity {

    public double x = 22.7765673;
    public double y = 86.1437094;
    public String label = "Marker";
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean mLocationPermissionGranted;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);

        toolbar = (Toolbar) findViewById(R.id.maps_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Locations");
        toolbar.setTitleTextColor(Color.WHITE);

        getLocationPermission();
        if (!canGetLocation() == true) {
            showSettingsAlert();
        }

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        java.util.Collections.sort(expandableListTitle);
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        final int[] prevExpandPosition = {-1};
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (prevExpandPosition[0] >= 0 && prevExpandPosition[0] != groupPosition) {
                    expandableListView.collapseGroup(prevExpandPosition[0]);
                }
                prevExpandPosition[0] = groupPosition;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();*/

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel A")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.780257;              //set latitide of location
                    y = 86.144046;              //set longitude of loaction
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);        //set label which will be shown over marker
                    bundle.putString("MarkerText", label);  //put all values in bundle
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);

                    intent.putExtras(bundle);           //put extras into the intent
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel B")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.781518;
                    y = 86.144176;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel C")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.781648;
                    y = 86.142468;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel D")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.780168;
                    y = 86.142686;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel E")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.773396;
                    y = 86.143955;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel F")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.773324;
                    y = 86.142748;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel G")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.7721714;
                    y = 86.1425037;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel H")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.771869;
                    y = 86.1435038;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel I")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.7719442;
                    y = 86.1448979;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel J")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.7718403;
                    y = 86.1459633;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Hostel K")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.77172;
                    y = 86.1468302;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Rani Laxmi Bai Hall of Residence")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777976;
                    y = 86.146188;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Ambedkar Hall of Residence")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.778205;
                    y = 86.145484;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Shyam Da")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.771659;
                    y = 86.143602;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("NIT Canteen")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.778740;
                    y = 86.143004;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("NIT Store")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777984;
                    y = 86.144303;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Sudha")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777691;
                    y = 86.144950;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Amul Cafe")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.7749516;
                    y = 86.14407;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Pradeep Restaurant")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.779535;
                    y = 86.143044;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Vishwakarma Sabhagriha (VSG)")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777102;
                    y = 86.143569;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Technology Student Gymkhana (TSG)")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.775086;
                    y = 86.143805;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Basket Ball Court (BBC)")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.779662;
                    y = 86.143279;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Pronite Ground")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.780823;
                    y = 86.143414;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Downs Ground")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.774838;
                    y = 86.143081;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Rooms 312 and 322")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.776777;
                    y = 86.143486;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Rooms 212 and 222")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777346;
                    y = 86.143826;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("CSE Front Arena")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777924;
                    y = 86.143891;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Room 113")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777924;
                    y = 86.143891;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Computer Centre (CC) ")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777255;
                    y = 86.145329;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("Library")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.776299;
                    y = 86.145114;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("NIT Guest House")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.776827;
                    y = 86.149229;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("SBI ATM")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777704;
                    y = 86.144280;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("ICICI Bank ATM")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777792;
                    y = 86.144307;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition).equals("State Bank of India")) {
                    Intent intent = new Intent(MapLocationActivity.this, MapsActivity.class);
                    Bundle bundle = new Bundle();
                    x = 22.777431;
                    y = 86.144229;
                    label = expandableListDetail.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition);
                    bundle.putString("MarkerText", label);
                    bundle.putDouble("Xcoordinate", x);
                    bundle.putDouble("Ycoordinate", y);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                return false;
            }

        });
    }

    private void getLocationPermission() {
    /*
     * Request location permission, so that we can get the location of the
     * device. The result of the permission request is handled by a callback,
     * onRequestPermissionsResult. 22.776827, 86.149229
     */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }
    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("Location not enabled!");

        // Setting Dialog Message
        alertDialog.setMessage("Click to enable or the app will not run");

        // On pressing Settings button
        alertDialog.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                });

        alertDialog.show();
    }
    public boolean canGetLocation() {
        boolean result = true;
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        if (lm == null)

            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // exceptions will be thrown if provider is not permitted.
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        try {
            network_enabled = lm
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }
        if (gps_enabled == false || network_enabled == false) {
            result = false;
        } else {
            result = true;
        }

        return result;
    }

}
