package br.com.ieadam.dominio;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import br.com.ieadam.utils.ReflectionsUtil;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -1094782059469169706L;

	@Transient
	private boolean checked;

	@Transient
	private int id = 0;

	public AbstractEntity() {
	}

	@PostLoad
	void loadId() {
		try {
			Field field = ReflectionsUtil.findAnnotatedFields(this.getClass(),
					Id.class)[0];
			field.setAccessible(true);
			id = new Integer(field.get(this).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isPersistent() {
		return getId() != 0;
	}

	/** HashCode. */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == 0) ? 0 : id));
		return result;
	}

	/** Equals. */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		final AbstractEntity other = (AbstractEntity) obj;

		if ((this.id == 0) || (other.id == 0)) {
			return false;
		}

		if (this.id != other.id) {
			return false;
		}

		return true;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

}
