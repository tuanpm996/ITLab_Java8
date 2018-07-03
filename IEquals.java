@FunctionalInterface
public interface IEquals<T> {
	int compare(T obj, T other);
	boolean equals(Object test);
}
