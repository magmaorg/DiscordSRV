/*
 * DiscordSRV - https://github.com/DiscordSRV/DiscordSRV
 *
 * Copyright (C) 2016 - 2024 Austin "Scarsz" Shapiro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package github.scarsz.discordsrv.api.events;

import github.scarsz.discordsrv.objects.MessageFormat;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * <p>Called before DiscordSRV has processed a death message, modifications may be overwritten by DiscordSRV's processing.</p>
 */
@SuppressWarnings({"LombokGetterMayBeUsed", "LombokSetterMayBeUsed"})
public class DeathMessagePreProcessEvent extends GameEvent<PlayerDeathEvent> implements Cancellable {

    private boolean cancelled;

    private String deathMessage;
    private String channel;
    private MessageFormat messageFormat;

    public DeathMessagePreProcessEvent(String channel, MessageFormat messageFormat, Player player, String deathMessage, PlayerDeathEvent triggeringBukkitEvent) {
        super(player, triggeringBukkitEvent);
        this.channel = channel;
        this.messageFormat = messageFormat;
        this.deathMessage = deathMessage;
    }

    @Deprecated
    public DeathMessagePreProcessEvent(String channel, MessageFormat messageFormat, Player player, String deathMessage) {
        super(player, null);
        this.channel = channel;
        this.messageFormat = messageFormat;
        this.deathMessage = deathMessage;
    }

    @Deprecated
    public DeathMessagePreProcessEvent(String channel, String message, Player player, String deathMessage) {
        super(player, null);
        this.channel = channel;
        MessageFormat messageFormat = new MessageFormat();
        messageFormat.setContent(message);
        this.messageFormat = messageFormat;
        this.deathMessage = deathMessage;
    }

    @Deprecated
    public String getMessage() {
        return messageFormat.getContent();
    }

    @Deprecated
    public void setMessage(String message) {
        MessageFormat messageFormat = new MessageFormat();
        messageFormat.setContent(message);
        this.messageFormat = messageFormat;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public String getDeathMessage() {
        return this.deathMessage;
    }

    public String getChannel() {
        return this.channel;
    }

    public MessageFormat getMessageFormat() {
        return this.messageFormat;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setDeathMessage(String deathMessage) {
        this.deathMessage = deathMessage;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setMessageFormat(MessageFormat messageFormat) {
        this.messageFormat = messageFormat;
    }
}
