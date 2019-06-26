package com.example.firstapp;

public class Sensors {

    private String flagName;
    private String sensorName;
    private int sensorValue;

    public Sensors(String sensorName, String flagName, int valueSensor) {
        this.sensorName= sensorName;
        this.flagName= flagName;
        this.sensorValue= valueSensor;
    }

    public int getValueSensor() {
        return sensorValue;
    }

    public void setValueSensor(int valueSensor) {
        this.sensorValue = valueSensor;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}
