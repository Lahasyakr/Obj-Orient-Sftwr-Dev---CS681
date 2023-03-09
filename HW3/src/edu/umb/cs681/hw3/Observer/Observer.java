package edu.umb.cs681.hw3.Observer;


public interface Observer<T> {
	public void update(Observable<T> sender, T event);
}
