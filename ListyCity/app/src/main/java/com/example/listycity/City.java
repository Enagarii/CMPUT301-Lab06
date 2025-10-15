package com.example.listycity;


import androidx.annotation.Nullable;

import java.util.Objects;

/**
 * This class defines a City
 */
public class City implements Comparable
{
	private String city;
	private String province;

	City(String city, String province)
	{
		this.city = city;
		this.province = province;
	}

	/**
	 * Returns the city name
	 * @return String of city name
	 */
	public String getCityName()
	{
		return this.city;
	}

	/**
	 * Returns the province name
	 * @return String of province name
	 */
	public String getProvinceName()
	{
		return this.province;
	}

	/**
	 * Sets the province name
	 * @param province
	 */
	public void setProvince(String province)
	{
		this.province = province;
	}

	/**
	 * Sets the city name
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * Compares cities, used for Comparable
	 * @param o the object to be compared.
	 * @return -1 if the caller is greater, 1 if the caller is smaller
	 */
	@Override
	public int compareTo(Object o)
	{
		City city = (City)o;

		return this.city.compareTo(city.getCityName());
	}

	/**
	 * Overrides equals to compare two city objects together
	 * @param obj Object of the city class
	 * @return true or false depending on whether or not the two cities are the same
	 */
	@Override
	public boolean equals(@Nullable Object obj)
	{
		if (!(obj instanceof City))
		{
			return false;
		} else
		{
			City city = (City) obj;
			return this.city.equals(city.city) && this.province.equals(city.province);
		}
	}

	/**
	 * Makes a unique hash for each unique City object using their city and province
	 * @return int of a unique hash
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(this.city, this.province);
	}
}
