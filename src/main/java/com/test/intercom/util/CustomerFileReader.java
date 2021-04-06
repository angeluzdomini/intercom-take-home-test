package com.test.intercom.util;

import com.test.intercom.dataobject.CustomerDO;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Customer file reader to manage reading customer list from file.
 */
public class CustomerFileReader {

    /**
     * Read customer file list as json and return the list of customerDO.
     *
     * @param fileName the file name
     * @return the list
     */
    public List<CustomerDO> readCustomerFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        List<CustomerDO> customerDOList = new ArrayList<>();
        try {
            //Read from the given file from resources folder.
            if (fileName != null && !fileName.isEmpty()) {
                InputStream inputStream = classLoader.getResourceAsStream(fileName);

                if (inputStream == null) {
                    throw new IllegalArgumentException("file not found! " + fileName);
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                //read each line using the buffered reader and process the customer data to add to the list.
                while (reader.ready()) {
                    String line = reader.readLine();
                    customerDOList.add(processCustomerDataRow(line));
                }
            } else {
                throw new IllegalArgumentException("Invalid value for file name.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch(JSONException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return customerDOList;
    }

    /*
     * Process each input line into json object and return corresponding customerDO object.
     *
     * @param row the row from input stream
     * @return customerDO
     */
    private CustomerDO processCustomerDataRow(String row) throws JSONException {
        //convert the string to JSONObject
        JSONObject result= new JSONObject(row);

        int id = result.getInt("user_id");
        String name = result.getString("name");
        double latitude = Double.parseDouble(result.getString("latitude"));
        double longitude = Double.parseDouble(result.getString("longitude"));

        return new CustomerDO(id, name, latitude, longitude);
    }
}
