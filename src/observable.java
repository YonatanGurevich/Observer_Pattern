
public interface observable {

	// The interface representing an observable in the observer design pattern
	
	public void addObserver(observer o);
	public void removeObserver(observer o);
	public void notifyObservers();
}
