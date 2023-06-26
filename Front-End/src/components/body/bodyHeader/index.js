import React from "react";
import AddDialog from "./addDialog";
//import DeleteDialog from "./deleteDialog";
//import EditDialog from "./editDialog";
//import Button from "@mui/material/Button";
import { ButtonGroup } from "@material-ui/core";
import AdvanceSearch from "./advanceSearch";
import TextField from "@mui/material/TextField";
import "./style.css";
//import { Predict } from "./predict";
//import RefreshIcon from "@material-ui/icons/Refresh";
import { AnalyticsView } from "./analyticsView";

const BodyHeader = (props) => {
  console.log('Values sire');
  console.log("props.currentRow = ",props.currentRow)
  console.log("props.select = ",props.select)

  return (
    <div className="parentBodyHeader">
      <ButtonGroup>
        <AddDialog  className="Add"/>
        <AnalyticsView className="Analy"/>
      </ButtonGroup>

    
      <TextField
        type="search"
        variant="outlined"
        label="Search Customer Id"
        onChange={(e) => props.searchItems(e.target.value)}
        className="searchBox"
        size="small"
      />
      <ButtonGroup className="Adv">
      <AdvanceSearch   adv_Search={props.adv_Search} />
      </ButtonGroup>
    </div>
  );
};

export default BodyHeader;
