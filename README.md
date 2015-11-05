## Build

The build is based on Maven Tycho, so Maven 3 has to be installed on the system (https://maven.apache.org/). 
The build can be started by calling the following command in the root directory of the odesign-designer repo:
```bash
mvn clean package
```
The zipped update site is then located at "odesign-designer/odesign.design.updatesite/target/odesign-designer-X.Y.Z-SNAPSHOT.zip"
Where X.Y.Z is the current version number of the odesign-designer.

## Installation

The simplest way to use the editor is to simply clone this repository and import the project to your workspace. Then you are already able to use the editor, since Sirius editors are interpreted they can be used in the same workspace where they are defined.

Alternatively you can do a propper installation via an update site. Currently there is no hosted update site, so the project has to be [built](#build) first. 
The resulting update site in XYZ can be installed via the "Help -> Install New Software" main menu dialogue.
In most operating systems the easiest way is to drop the zipped update site from the file navigator on the dialogue.

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
Node Styles can be dropped in NodeMappings. These elements show how the style looks like (at least for static, non-computed configuration) 
Semantic Element: Domain Class

#### Containers

Container, Container Import + Imported Container Mapping 
Container Styles can be dropped in NodeMappings. These elements show how the style looks like (at least for static, non-computed configuration) 
Semantic Element: Domain Class

#### Bordered Nodes

Can be placed in Nodes, Containers or Bordered Nodes 
Node Styles can be dropped in BorderNodeMappings. These elements show how the style looks like (at least for static, non-computed configuration) 
Semantic Element: Domain Class

#### Edges

Element Based Edge: A domain model element represents the edge. 
Semantic Elements: Domain Class, Source Reference, Target Reference 

Relation Based Edge: Represents reference of source mapping domain class to target mapping domain class 
Semantic Elements: Target Reference 

## Known Limitations and Errors

The Diagram Editor can currently not save. This is the result of a hard coded removal of .odesign files in the Sirius saving method:
```
org.eclipse.sirius.business.internal.session.IsModifiedSavingPolicy#computeResourcesToSave(Set<Resource> scope, Map<?, ?> options, IProgressMonitor monitor) 
```

The properties view for the graphical editor is the default one, and by far not comparable with the one shipped with the default Odesign editor.
It does not seem possible to reuse the one from the Odesign editor. Alternatively an action is implemented to double click on graphical elements in the 
Odesign Designer to jump into the Odesign editor and select the element that was edited. This way the properties view of the default editor is shown.
Unfortunately the edited Odesign file has always to be saved so that the two editors get aware of the changes performed in the other.

Setting the EReferences for Edges via the tools in the palette currently only works for edges that do not connect other edges (neither source or target is an EdgeMapping). 

Currently font styles cannot be shown in the designer as specified, since the way how font formats are represented was changed in Sirius 3.
There is a related [bug entry] (https://bugs.eclipse.org/bugs/show_bug.cgi?id=470297), if this is fixed fonts can be shown as specified again.

Currently the editor throws some exceptions that will be shown on the standard out of the Eclipse instance, because some model features are not found.
This problems still has to be investigated.
