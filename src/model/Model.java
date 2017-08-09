package model;

import utils.Config;
import utils.IFactory;

public abstract class Model {

	protected String uuid;

	public Model() {

		uuid = Config.generateUUID();

	}

	public Model(String uuid) {

		this.uuid = uuid;

	}

}
