
## Installation

Currently there is no build script, so the odesign.odesign project has to be imported into an Eclipse (Mars) with Sirius installed
and can be exported as a deployable plug-in. In future a build script and eventually an update site will be provided for installation.

## Usage

### Create Diagram Definition Diagram

Create a regular Sirius Viewpoint Specification Model, create a Viewpoint in that model and in that a Diagram Description. Make sure to add at least one meta model to the Diagram Description.
In that Diagram Description create at least a Default Layer. 
Then create a new representations file for the Odesign model (e.g. right click on the model file and select menu item "New -> Representations File"). Double click in the Project Explorer view, 
or the Model Explorer view (Sirius perspective). This will open the .aird file in the view (sub-elements will appear in the tree view) and allows navigation to the respective .odesign model. 
Navigat to the Layer created in the Odesign model and right click. In the context menu select item "New Representation -> new Layer Styles". This creates a diagram that allows definition of the
graphical elements that can be placed on the selected layer.

TODO Provide Screenshots

### Editing Diagram Definition Diagram

TODO Describe Elements to be placed.

#### Nodes 

Node, Node Import + Imported Node Mapping 
Semantic Element: Domain Class

#### Containers

Container, Container Import + Imported Container Mapping
Semantic Element: Domain Class

#### Bordered Nodes

Can be placed in Nodes, Containers or Bordered Nodes
Semantic Element: Domain Class

#### Edges

Element Based Edge: A model element represents the edge. 
Semantic Elements: Domain Class, Source Reference, Target Reference 

Relation Based Edge: Represents reference of source mapping Domain Class to target mapping Domain Class
Semantic Elements: Target Reference 

## Known Limitations and Errors

The Diagram Editor can currently not save. This is the result of a hard coded removal of .odesign files for saving in method
```
org.eclipse.sirius.business.internal.session.IsModifiedSavingPolicy#computeResourcesToSave(Set<Resource> scope, Map<?, ?> options, IProgressMonitor monitor) 
```

The properties view for the graphical editor is the default one, and by far not comparable with the one shipped with the default Odesign editor.
It does not seem possible to reuse the one from the Odesign editor. Alternatively an action is implemented to double click on graphical elements in the 
Odesign Designer to jump into the Odesign editor and select the element that was edited. This way the properties view of the default editor is shown.
Unfortunately the edited Odesign file has always to be saved so that the two editors get aware of the changes performed in the other.

Setting the EReferences for Edges via the tools in the palette currently only works for edges that do not connect other edges (neither source or target is an EdgeMapping). 

Currently the editor throws some exceptions that will be shown on the standard out of the Eclipse instance, because not all icons are actually available and some model features are not found.
This still has to be investigated.