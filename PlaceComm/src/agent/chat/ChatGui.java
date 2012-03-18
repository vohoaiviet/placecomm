/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent.chat;

/**
 *
 * @author ATuan
 */
public interface ChatGui {
void notifyParticipantsChanged(String[] names);
void notifySpoken(String speaker, String sentence);
void dispose();
}
