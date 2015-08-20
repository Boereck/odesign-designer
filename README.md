
== Installation

Currently there is no build script, so the odesign.odesign project has to be imported into an Eclipse (Mars) with Sirius installed
and can be exported as a deployable plug-in. In future a build script and eventually an update site will be provided for installation.

== Usage

Create a regular Sirius Viewpoint Specification Model, create a Viewpoint in that model and in that a Diagram Description. Make sure to add at least one meta model to the Diagram Description.
In that Diagram Description create at least a Default Layer. 
Then create a new representations file for the Odesign model (e.g. right click on the model file and select menu item "New -> Representations File"). Double click in the Project Explorer view, 
or the Model Explorer view (Sirius perspective). This will open the .aird file in the view (sub-elements will appear in the tree view) and allows navigation to the respective .odesign model. 
Navigat to the Layer created in the Odesign model and right click. In the context menu select item "New Representation -> new Layer Styles". This creates a diagram that allows definition of the
graphical elements that can be placed on the selected layer.

TODO Describe Elements to be placed.
TODO Provide Screenshots

== Known Limitations

The Diagram Editor can currently not save. This is the result of a hard coded removal of .odesign files for saving in method
'''
org.eclipse.sirius.business.internal.session.IsModifiedSavingPolicy#computeResourcesToSave(Set<Resource> scope, Map<?, ?> options, IProgressMonitor monitor) 
'''

The properties view for the graphical editor is the default one, and by far not comparable with the one shipped with the default Odesign editor.
It does not seem possible to reuse the one from the Odesign editor. Alternatively an action is implemented to double click on graphical elements in the 
Odesign Designer to jump into the Odesign editor and select the element that was edited. This way the properties view of the default editor is shown.
Unfortunately the edited Odesign file has always to be saved so that the two editors get aware of the changes performed in the other.

Setting the EReferences for Edges via the tools in the palette currently only works for edges that do not connect other edges (neither source or target is an EdgeMapping).