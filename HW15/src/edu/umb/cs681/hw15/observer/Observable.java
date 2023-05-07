package edu.umb.cs681.hw15.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable<T> {
	private LinkedList<Observer<T>> observers = new LinkedList<>();
	private ReentrantLock lockObs = new ReentrantLock();

	public void addObserver(Observer<T> o) {
		try {
			lockObs.lock();
			observers.add(o);
		} finally {
			lockObs.unlock();
		}
	}

	public void clearObservers() {
		try {
			lockObs.lock();
			observers.clear();
		} finally {
			lockObs.unlock();
		}

	}

	public List<Observer<T>> getObservers() {
		try {
			lockObs.lock();
			return observers;
		} finally {
			lockObs.unlock();
		}
	}

	public int countObservers() {
		try {
			lockObs.lock();
			return observers.size();
		} finally {
			lockObs.unlock();
		}

	}

	public void removeObserver(Observer<T> o) {
		try {
			lockObs.lock();
			observers.remove(o);
		} finally {
			lockObs.unlock();
		}
	}

	public void notifyObservers(T event) {
		LinkedList<Observer<T>> observersLocal;
		try {
			lockObs.lock();
			observersLocal = observers;

		} finally {
			lockObs.unlock();
		}

		observersLocal.forEach((observer) -> {
			observer.update(this, event);
		});
	}

}