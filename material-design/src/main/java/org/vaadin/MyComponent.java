package org.vaadin;

import org.vaadin.client.MyComponentClientRpc;
import org.vaadin.client.MyComponentServerRpc;
import org.vaadin.client.MyComponentState;

import com.vaadin.shared.MouseEventDetails;

// This is the server-side UI component that provides public API 
// for MyComponent
public class MyComponent extends com.vaadin.ui.AbstractComponent {

	private int clickCount = 0;

	// To process events from the client, we implement ServerRpc
	private MyComponentServerRpc rpc = new MyComponentServerRpc() {

		// Event received from client - user clicked our widget
		public void clicked(MouseEventDetails mouseDetails) {
			
			// Send nag message every 5:th click with ClientRpc
			if (++clickCount % 5 == 0) {
				getRpcProxy(MyComponentClientRpc.class)
						.alert("Ok, that's enough!");
			}
			
			// Update shared state. This state update is automatically 
			// sent to the client. 
			getState().text = "You have clicked " + clickCount + " times";
		}
	};

	public MyComponent() {

		// To receive events from the client, we register ServerRpc
		registerRpc(rpc);
	}

	// We must override getState() to cast the state to MyComponentState
	@Override
	public MyComponentState getState() {
		return (MyComponentState) super.getState();
	}
}
