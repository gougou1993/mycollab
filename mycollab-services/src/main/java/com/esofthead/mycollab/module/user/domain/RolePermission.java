/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
/*Domain class of table s_role_permission*/
package com.esofthead.mycollab.module.user.domain;

import com.esofthead.mycollab.core.arguments.ValuedBean;
import com.esofthead.mycollab.core.db.metadata.Column;
import com.esofthead.mycollab.core.db.metadata.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;

@SuppressWarnings("ucd")
@Table("s_role_permission")
public class RolePermission extends ValuedBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role_permission.id
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    @Column("id")
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role_permission.roleid
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    @Column("roleid")
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role_permission.roleVal
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    @Length(max=65535, message="Field value is too long")
    @Column("roleVal")
    private String roleval;

    private static final long serialVersionUID = 1;

    public final boolean equals(Object obj) {
        if (obj == null) { return false;}
        if (obj == this) { return true;}
        if (obj.getClass() != getClass()) { return false;}
        RolePermission item = (RolePermission)obj;
        return new EqualsBuilder().append(id, item.id).build();
    }

    public final int hashCode() {
        return new HashCodeBuilder(447, 37).append(id).build();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role_permission.id
     *
     * @return the value of s_role_permission.id
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role_permission.id
     *
     * @param id the value for s_role_permission.id
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role_permission.roleid
     *
     * @return the value of s_role_permission.roleid
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role_permission.roleid
     *
     * @param roleid the value for s_role_permission.roleid
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role_permission.roleVal
     *
     * @return the value of s_role_permission.roleVal
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    public String getRoleval() {
        return roleval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role_permission.roleVal
     *
     * @param roleval the value for s_role_permission.roleVal
     *
     * @mbggenerated Mon Sep 21 13:52:02 ICT 2015
     */
    public void setRoleval(String roleval) {
        this.roleval = roleval;
    }

    public enum Field {
        id,
        roleid,
        roleval;

        public boolean equalTo(Object value) {
            return name().equals(value);
        }
    }
}