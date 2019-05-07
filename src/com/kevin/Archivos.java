package com.kevin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Archivos implements Serializable {
	
	public static void escribirObjeto( Object objeto ,String nombre){
		try {
			FileOutputStream fos = new FileOutputStream(nombre);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objeto);
			oos.close();
			fos.close();
		} catch (InvalidClassException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "InvalidClassExcpetion", JOptionPane.ERROR_MESSAGE);
		}catch(NotSerializableException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"NotSerializableException", JOptionPane.ERROR_MESSAGE);
		}catch(IOException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Object leerObjeto(String name){
		Object objeto = null;
		try {
			FileInputStream fis = new FileInputStream(name);
			ObjectInputStream ois = new ObjectInputStream(fis);
				objeto = ois.readObject();
			ois.close();
			fis.close();
		} catch (InvalidClassException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "InvalidClassException", JOptionPane.ERROR_MESSAGE);
		}catch(NotSerializableException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"NotSerializableException", JOptionPane.ERROR_MESSAGE);
		}catch(IOException e ) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage() , "ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
		}
		return objeto;
	}
}
