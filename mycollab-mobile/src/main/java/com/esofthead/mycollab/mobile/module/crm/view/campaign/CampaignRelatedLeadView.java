/**
 * This file is part of mycollab-mobile.
 *
 * mycollab-mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-mobile.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.mobile.module.crm.view.campaign;

import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.core.arguments.SearchField;
import com.esofthead.mycollab.eventmanager.ApplicationEvent;
import com.esofthead.mycollab.eventmanager.ApplicationEventListener;
import com.esofthead.mycollab.eventmanager.EventBus;
import com.esofthead.mycollab.mobile.module.crm.events.LeadEvent;
import com.esofthead.mycollab.mobile.module.crm.ui.AbstractRelatedListView;
import com.esofthead.mycollab.mobile.module.crm.view.lead.LeadListDisplay;
import com.esofthead.mycollab.mobile.ui.TableClickEvent;
import com.esofthead.mycollab.module.crm.domain.SimpleCampaign;
import com.esofthead.mycollab.module.crm.domain.SimpleLead;
import com.esofthead.mycollab.module.crm.domain.criteria.LeadSearchCriteria;
import com.esofthead.mycollab.vaadin.AppContext;

/**
 * 
 * @author MyCollab Ltd.
 * @since 4.1
 * 
 */
public class CampaignRelatedLeadView extends
		AbstractRelatedListView<SimpleLead, LeadSearchCriteria> {
	private static final long serialVersionUID = -4503624862562854777L;
	private SimpleCampaign campaign;

	public CampaignRelatedLeadView() {
		super();
		setCaption("Related Leads");
		this.tableItem = new LeadListDisplay("leadName");
		this.tableItem
				.addTableListener(new ApplicationEventListener<TableClickEvent>() {
					private static final long serialVersionUID = 5527577797731688683L;

					@Override
					public Class<? extends ApplicationEvent> getEventType() {
						return TableClickEvent.class;
					}

					@Override
					public void handle(TableClickEvent event) {
						final SimpleLead lead = (SimpleLead) event.getData();
						if ("leadName".equals(event.getFieldName())) {
							EventBus.getInstance().fireEvent(
									new LeadEvent.GotoRead(
											CampaignRelatedLeadView.class, lead
													.getId()));
						}
					}
				});
		this.setContent(tableItem);
	}

	private void loadLeads() {
		final LeadSearchCriteria searchCriteria = new LeadSearchCriteria();
		searchCriteria.setSaccountid(new NumberSearchField(SearchField.AND,
				AppContext.getAccountId()));
		searchCriteria.setCampaignId(new NumberSearchField(SearchField.AND,
				this.campaign.getId()));
		this.tableItem.setSearchCriteria(searchCriteria);
	}

	public void displayLeads(SimpleCampaign campaign) {
		this.campaign = campaign;
		loadLeads();
	}

	@Override
	public void refresh() {
		loadLeads();
	}

}
