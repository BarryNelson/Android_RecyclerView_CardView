/*
 * Copyright (C) 2014 Francesco Azzola
 *  Surviving with Android (http://www.survivingwithandroid.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.survivingwithandroid.reccard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSurname.setText(ci.surname);
        contactViewHolder.vEmail.setText(ci.email);
        contactViewHolder.vTitle.setText(ci.name + " " + ci.surname);
        System.out.println("--> onBindViewHolder: "+ci.name);
    }

    /**
     * Item has scrolled off screen
     * @param holder
     */
    @Override
    public void onViewDetachedFromWindow(ContactViewHolder holder) {
        System.out.println("dd> " + holder.vName.getText());
        super.onViewDetachedFromWindow(holder);
    }

    /**
     * itme is attached, may not be fully visible until scrolled completely into view
     * @param holder
     */
    @Override
    public void onViewAttachedToWindow(ContactViewHolder holder) {
        System.out.println("at> " + holder.vName.getText());
        super.onViewAttachedToWindow(holder);
    }

    /**
     * item is being recycled
     * @param holder
     */
    @Override
    public void onViewRecycled(ContactViewHolder holder) {
        System.out.println("rr> " + holder.vName.getText());
        super.onViewRecycled(holder);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        System.out.println("++> onCreateViewHolder " + i);
        return new ContactViewHolder(itemView);
    }

    /**
     * uses View.OnClickListener to receive line item selection
     */
    public static class ContactViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;

        public ContactViewHolder(View v) {
            super(v);
            vName    = (TextView) v.findViewById(R.id.txtName);
            vSurname = (TextView) v.findViewById(R.id.txtSurname);
            vEmail   = (TextView) v.findViewById(R.id.txtEmail);
            vTitle   = (TextView) v.findViewById(R.id.title);
            System.out.println("--> ContactViewHolder: "+vName.getText());
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            System.out.println("--> onClick: "+vName.getText());
        }
    }
}
