package message;

/**
 * Manages message groups in abUTA.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
 public class Group {
   /**
     * Creates a new Group.
     *
     * @param name         the name of the new group
     * @throws             IllegalArgumentException if the name is null
     *                     or is empty.
     * @since              1.0
     */
    public Group(String name) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Invalid group name");
        this.name = name;
        this.active = true;
    }
   /**
     * Returns the active status of the Group.
     *
     * @return             true if the Group is active, false otherwise.
     * @since              1.0
     */
    public boolean isActive() {
        return active;
    }
   /**
     * Sets the status of the Group to inactive.
     *
     * @since              1.0
     */
    public void disable() {
        active = false;
    }
   /**
     * Sets the status of the Group to active.
     *
     * @since              1.0
     */
    public void enable() {
        active = true;
    }
    /**
     * Returns the name and active status of the Group.
     *
     * @return             name and (if not active) " [inactive]".
     * @since              1.0
     */
   @Override
    public String toString() {
        return name + (active ? "" : " [inactive]");
    }
    private String name;
    private boolean active;
}
