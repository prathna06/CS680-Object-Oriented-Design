package edu.umb.CS680.HW16;

public interface Observer<T> {
	public void update(Observable<T> sender, T event);
}
