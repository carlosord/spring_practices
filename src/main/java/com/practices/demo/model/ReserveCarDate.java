package com.practices.demo.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.practices.demo.model.compositekey.ReserveCarDateKey;

/**
* The Class ReserveCar.
*/
@Entity
public class ReserveCarDate {

    /** The reserveid. */
    @EmbeddedId
    ReserveCarDateKey reserveid;

    /** The person. */
    @ManyToOne
    @MapsId("person_id")
    @JoinColumn(name = "person_id")
    Person person;

    /** The car. */
    @ManyToOne
    @MapsId("car_id")
    @JoinColumn(name = "car_id")
    Car car;

    /** The startdatereserve. */
    private Date startCarReserve;

    /** The finaldatereserve. */
    private Date finishCarReserve;

    /**
     * Instantiates a new reserve car date.
     */
    public ReserveCarDate() {
    }

    /**
     * Gets the reserveid.
     *
     * @return the reserveid
     */
    public ReserveCarDateKey getReserveid() {
        return reserveid;
    }

    /**
     * Sets the reserveid.
     *
     * @param reserveid the new reserveid
     */
    public void setReserveid(ReserveCarDateKey reserveid) {
        this.reserveid = reserveid;
    }

    /**
     * Gets the person.
     *
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the person.
     *
     * @param person the new person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets the car.
     *
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the car.
     *
     * @param car the new car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @return the startCarReserve
     */
    public Date getStartCarReserve() {
        return startCarReserve;
    }

    /**
     * @param startCarReserve the startCarReserve to set
     */
    public void setStartCarReserve(Date startCarReserve) {
        this.startCarReserve = startCarReserve;
    }

    /**
     * @return the finishCarReserve
     */
    public Date getFinishCarReserve() {
        return finishCarReserve;
    }

    /**
     * @param finishCarReserve the finishCarReserve to set
     */
    public void setFinishCarReserve(Date finishCarReserve) {
        this.finishCarReserve = finishCarReserve;
    }

}