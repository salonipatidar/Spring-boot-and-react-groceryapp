import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { Link } from 'react-router-dom';
//import axios from 'axios';

//function HomeScreen(props)
/*{ /*const [products,setProduct]=useState([]);
  useEffect(()=>{
    const fetchData = async ()=>
    {
      const {data} = await axios.get("/api/products");
      setProduct(data)
    }
    fetchData();
    return ()=>{

    };
  },[])  */
  /*class HomeScreen extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        products: [],
        isLoaded: false,
      }
    }
    componentDidMount() {
      fetch('/api/products')
        .then(res =>   res.json())
        .then(json => {
          console.log(this.state.products)
          this.setState({
            isLoaded: true,
            products: json
          });
    })}
    render() {
      var { products = [] } = this.props;
      var { isLoaded } = this.state;
      if (!isLoaded) {
        return <div>Loading...</div>
      }*/
      class HomeScreen extends Component{
        state = {
          isLoading: true,
          producs: []
        };
        
        async componentDidMount(){
          const response = await fetch('/api/products');
          const body = await response.json();
          this.setState({producs: body, isLoading:false});
        }
        render() {
          const {producs, isLoading} = this.state;
        
          if (isLoading) {
            return <p>Loading...</p>;
          }
      else {
  
  return <ul className="products">
{ producs.map(product=>
<li key={product.id}>
<div className="product">
<Link to={'/product/'+product.id}><img className="product-image" src={product.images} alt="product" /></Link>
  
  <div className="product-name">
<Link to={'/product/'+product.id}>{product.name}</Link>
  </div>
  
</div>
</li>

)
      
      }
</ul>
      }
    }
    }

export default HomeScreen;