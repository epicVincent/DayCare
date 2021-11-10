package com.softwareEng.Daycare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DayCareDB implements Role.addRoles,Condition.addCondition,Parent.addParent,Staff.addStaff,Child.addChild {


    private DBHelper dbHelper;
    private SQLiteDatabase mDayCareDB;
    private final Context context;

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "DayCareDB";

    // Table Names
    private static final String tableStaff = "_staff";
    private static final String tableParents = "_parents";
    private static final String tableChildren = "_children";
    private static final String tablePayments = "_payments";
    private static final String tableSuppliers = "_suppliers";
    private static final String tableRoles = "_roles";
    private static final String tableConditions = "_conditions";

    // Common column names (person class)
    private static final String KEY_ID = "_id";
    private static final String sirname = "_sirname";
    private static final String lastname = "_lastname";
    private static final String firstname = "_firstname";


    // Parents & Staff Table - column nmaes
    private static final String NatId = "_NatId";
    private static final String telNo1 = "_telNo1";
    private static final String telNo2 = "_telNo2";
    private static final String role = "_role";
    // parent Table - column names
    private static final String Occupation = "_occupation";

    // staff Table - column names
    private static final String username = "_username";
    private static final String password = "_password";

    //role table columns

    //children_table columns
    public static final String age = "_age";
    public static final String condition = "_medCondition";
    public static final String parent = "_parent";

    //table condition columns
    public static final String severity = "_severity";

    //constructor
    public DayCareDB(Context context){
        this.context = context;
    }

    //implements creating roles
    @Override
    public long addroles(String mRole) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(role,mRole);
        return mDayCareDB.insert(tableRoles,null,contentValues);
    }

    @Override
    public long addcondition(int mSeverity, String medCondition) {
        ContentValues conditionValues = new ContentValues();
        conditionValues.put(severity,mSeverity);
        conditionValues.put(condition,medCondition);
        return mDayCareDB.insert(tableConditions,null,conditionValues);
    }

    @Override
    public long addparent(String mfirstName, String mlastName, String msurName, String mtelNo1, String mtelNo2, String mNatId, String moccupation) {
        ContentValues parentValues = new ContentValues();
        parentValues.put(firstname,mfirstName);
        parentValues.put(lastname,mlastName);
        parentValues.put(sirname,msurName);
        parentValues.put(telNo1,mtelNo1);
        parentValues.put(telNo2,mtelNo2);
        parentValues.put(NatId,mNatId);
        parentValues.put(Occupation,moccupation);
        return mDayCareDB.insert(tableParents,null,parentValues);
    }

    @Override
    public long addstaff(String mfirstName, String mlastName, String msurName, String mtelNo1, String mtelNo2, Role mrole,
                         String musername, String mpassword, String mNatId) {
        int role_id = mrole.getId();
        long dbInsertSig = 0;
        ContentValues staffValues = new ContentValues();
        staffValues.put(firstname,mfirstName);
        staffValues.put(lastname,mlastName);
        staffValues.put(sirname,msurName);
        staffValues.put(telNo1,mtelNo1);
        staffValues.put(telNo2,mtelNo2);
        staffValues.put(username,musername);
        staffValues.put(password,mpassword);
        staffValues.put(NatId,mNatId);
        staffValues.put(role,role_id);
        dbInsertSig =mDayCareDB.insert(tableStaff,null,staffValues);
        Log.i("dataDB","data saved insert sig:"+dbInsertSig);
        return dbInsertSig;

    }

    @Override
    public long addchild(String Surname, String FirstName, String LastName, Parent mparent, int age) {
        long dbInsertSig = 0;
        int parentPrimaryID = mparent.getId();
        ContentValues childValues = new ContentValues();
        childValues.put(firstname,FirstName);
        childValues.put(lastname,LastName);
        childValues.put(sirname,Surname);
        childValues.put(parent,parentPrimaryID);
        dbInsertSig = mDayCareDB.insert(tableChildren,null,childValues);
        Log.i("dataDB","data saved insert sig:"+dbInsertSig);
        return dbInsertSig;
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            String CREATE_TABLE_CONDITIONS = "CREATE TABLE "
                    + tableConditions + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+severity+ " INTEGER," + condition
                    + " TEXT" + ");";

            String CREATE_TABLE_ROLES = "CREATE TABLE "
                    + tableRoles + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + role
                    + " TEXT" + ");";


            String CREATE_TABLE_STAFF = "CREATE TABLE "
            + tableStaff + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + sirname
            + " TEXT," + firstname + " TEXT," +lastname + " TEXT," +telNo1 + " TEXT," +telNo2 +" TEXT," + NatId
            + " TEXT," +role +" INTEGER,"  + username +" TEXT," + password + " TEXT," +"FOREIGN KEY("+role+")" +
                    " REFERENCES " + tableRoles +"("+KEY_ID + ")"+ ");";

            String CREATE_TABLE_PARENT = "CREATE TABLE "
                    + tableParents + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + sirname
                    + " TEXT," + firstname + " TEXT," +lastname + " TEXT," +telNo1 + " TEXT," +telNo2 +" TEXT," + NatId
                    + " TEXT," +Occupation +" TEXT" + ");";

            String CREATE_TABLE_children = "CREATE TABLE "
                    + tableChildren + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + sirname
                    + " TEXT," + firstname + " TEXT," +lastname + " TEXT," +age + " INTEGER," +parent +" INTEGER," + condition+" TEXT," +
                    "FOREIGN KEY ("+condition+")" + " REFERENCES "+tableConditions +"("+condition+")," +
                     "FOREIGN KEY(" +parent+")"+ " REFERENCES "+tableParents+"("+KEY_ID+")"+");";

            db.execSQL(CREATE_TABLE_CONDITIONS);
            db.execSQL(CREATE_TABLE_ROLES);
            db.execSQL(CREATE_TABLE_STAFF);
            db.execSQL(CREATE_TABLE_PARENT);
            db.execSQL(CREATE_TABLE_children);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String dropTableConditions = "DROP TABLE IF EXISTS "+tableConditions;
            String dropTableParents = "DROP TABLE IF EXISTS "+tableParents;
            String dropTableRoles = "DROP TABLE IF EXISTS "+tableRoles;
            String dropTableStaff = "DROP TABLE IF EXISTS "+tableStaff;
            String dropTableChildren = "DROP TABLE IF EXISTS "+tableChildren;
            db.execSQL(dropTableChildren);
            db.execSQL(dropTableParents);
            db.execSQL(dropTableStaff);
            db.execSQL(dropTableConditions);
        }
    }

    public DayCareDB open() throws SQLException {
        dbHelper = new DBHelper(context);
        mDayCareDB = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

//    public interface addRoles {
//        public long addroles();
//    }
//    public interface addConditions {
//        void addconditions();
//    }
//    public interface addStaff {
//        void addstaff();
//    }
//    public interface addParents {
//        void addparents();
//    }
//    public interface addChilderen {
//        void addChildren();
//    }

    public ArrayList<Staff> getStaff(){
       ArrayList<Staff> stafflist = new ArrayList<>();
       String[] columns = new String[]{KEY_ID,sirname,firstname,lastname,telNo1,telNo2,NatId,role};
       Cursor cursor = mDayCareDB.query(tableStaff,columns,null,null,null,null,null);
        int colId = cursor.getColumnIndex(KEY_ID);
        int colSirname = cursor.getColumnIndex(sirname);
        int colLastname = cursor.getColumnIndex(lastname);
        int colFirstname = cursor.getColumnIndex(firstname);
        int colTel1 = cursor.getColumnIndex(telNo1);
        int colTel2 = cursor.getColumnIndex(telNo2);
        int colNatId = cursor.getColumnIndex(NatId);
        int colRole = cursor.getColumnIndex(role);

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            Staff staff = new Staff();
            staff.setId((int) cursor.getInt(colId));
            staff.setSurname(cursor.getString(colSirname));
            staff.setLastName(cursor.getString(colLastname));
            staff.setFirstName(cursor.getString(colFirstname));
            staff.setTelNo1(cursor.getString(colTel1));
            staff.setTelNo2(cursor.getString(colTel2));
            staff.setNatId(cursor.getString(colNatId));
            int specRole = cursor.getInt(colRole);
            staff.setRole(getSpecificRole(specRole));
            stafflist.add(staff);
        }
       return stafflist;
    }
    public Role getSpecificRole(int specRole){
        ArrayList<Role> reqRoles = (ArrayList<Role>) getRoles();
        Role reqrole = null;
        for(Role role:reqRoles){
            if(specRole == role.getId()){
                reqrole =role;
            }
        }
      return reqrole;
    }
    public ArrayList<Role> getRoles(){
        ArrayList<Role> rolelist = new ArrayList<>();
        String[] columns = new String[]{KEY_ID,role};
        Cursor cursor = mDayCareDB.query(tableRoles,columns,null,null,null,null,null);
        int colId = cursor.getColumnIndex(KEY_ID);
        int colRole = cursor.getColumnIndex(role);

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            Role role = new Role();
            role.setId((int) cursor.getInt(colId));
            role.setRole(cursor.getString(colRole));
            rolelist.add(role);
        }
        Log.i("roleSize",""+rolelist.size());
        return rolelist;
    }
}
