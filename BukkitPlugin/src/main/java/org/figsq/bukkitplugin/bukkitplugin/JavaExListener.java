package org.figsq.bukkitplugin.bukkitplugin;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.reactive.ObservableSubscription;
import kotlin.Unit;
import org.figsq.cobeventex.cobeventex.events.CobExEvents;

import java.util.ArrayList;
import java.util.List;

public final class JavaExListener implements ExListener {
    public static final JavaExListener INSTANCE = new JavaExListener();

    private JavaExListener(){}

    private static final List<ObservableSubscription<?>> registered = new ArrayList<>();

    @Override
    public void register() {
        registered.add(CobExEvents.START_TRADING.subscribe(Priority.NORMAL, e -> {
            System.out.println("[Java]: Trading started");
            return Unit.INSTANCE;
        }));
        registered.add(CobExEvents.PRE_TRADE_COMPLETE.subscribe(Priority.NORMAL, e -> {
            System.out.println("[Java]: Trade complete! (Triggered before the transaction is completed!)");
            return Unit.INSTANCE;
        }));
        registered.add(CobExEvents.BATTLE_INSTRUCTION.subscribe(Priority.NORMAL, e -> {
            System.out.println("[Java]: Battle instruction received! type>> " + e.getInterpreterInstruction().getClass());
            return Unit.INSTANCE;
        }));
    }

    @Override
    public void unregister() {
        registered.forEach(ObservableSubscription::unsubscribe);
        registered.clear();
    }
}
