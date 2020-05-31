package testdome;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

interface AlertDAO {
	public final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

	UUID addAlert(Date time);

	Date getAlert(UUID id);
}

class AlertService {
	private final AlertDAO storage;

	public AlertService(AlertDAO dao) {
		this.storage = dao;
	}

	public UUID raiseAlert() {
		return this.storage.addAlert(new Date());
	}

	public Date getAlertTime(UUID id) {
		return this.storage.getAlert(id);
	}
}

class MapAlertDAO implements AlertDAO {

	@Override
	public UUID addAlert(Date time) {
		UUID id = UUID.randomUUID();
		alerts.put(id, time);
		return id;
	}

	@Override
	public Date getAlert(UUID id) {
		return alerts.get(id);
	}
}