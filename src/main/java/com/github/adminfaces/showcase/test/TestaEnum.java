package com.github.adminfaces.showcase.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.model.SelectItem;

import com.github.adminfaces.showcase.model.CATEGORIAUSUARIO;

public class TestaEnum {

	public static void main(String[] args) {	
		Random rd = new Random();
		Integer random = rd.nextInt(10000);
		
		System.out.println(random);
	}	
	// 329611835
	// 329611835
	public void testaCat() {
		List<SelectItem> listaCat = new ArrayList<>();
		listaCat = CATEGORIAUSUARIO.getCatUsu();
		
		for (SelectItem item : listaCat) {
			System.out.println(item.getValue());
		}
	}
	
}
