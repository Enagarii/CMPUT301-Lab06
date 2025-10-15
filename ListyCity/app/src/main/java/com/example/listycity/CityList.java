package com.example.listycity;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *  This class holds a list of City objects
 */
public class CityList
{
	private ArrayList<City> cities = new ArrayList<>();

	/**
	 * This adds a city to the list if it does not exist
	 * @param city: City object to potentially add
	 *
	 */
	public void add(City city)
	{
		if (cities.contains(city))
		{
			throw new IllegalArgumentException();
		}
		cities.add(city);
	}

	/**
	 * Returns a sorted list of cities
	 * @return list of cities
	 */
	public List<City> getCities()
	{
		List<City> list = cities;
		Collections.sort(list);
		return list;
	}

	/**
	 * Returns whether or not the city is in the city list
	 * @param city the city to check for
	 * @return boolean, true for if the city is in the list, false for the city is not in the list
	 */
	public boolean hasCity(City city)
	{
		if (cities.contains(city))
		{
			return true;
		}
		return false;
	}

	/**
	 * Removes the city if the city exists in the list
	 * @param city City object to be removed
	 */
	public void delete(City city)
	{
		if (hasCity(city))
		{
			cities.remove(city);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns an integer representing the number of Cities in the CityList
	 * @return int representing the cities in the list
	 */
	public int countCities()
	{
		return cities.size();
	}

}
