import React,{Component, useEffect, useState} from 'react';

import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { cleanup } from '@testing-library/react';
import { detailsProduct } from '../actions/productActions';
// class ProductScreen extends Component{
// state = {
//   isLoading: true,
//   products: []
// };

// async componentDidMount(){
//   const response = await fetch('/api/products/products');
//   const body = await response.json();
//   this.setState({products: body, isLoading:false});
// }
// render() {
//   const {products, isLoading} = this.state;

//   if (isLoading) {
//     return <p>Loading...</p>;
//   }
function ProductScreen(props){   
  const productDetails = useSelector(state=>state.productDetails);
  const [qty, setQty] = useState(1);
  const{product,loading,error}= productDetails;
  const dispatch = useDispatch();
  
  useEffect(()=>{
    dispatch(detailsProduct(props.match.params.id));
    return() =>{
      //
    };

  },[]

  )

  const handleAddToCart = () => {
    props.history.push('/cart/' + props.match.params.id + '?qty=' + qty);
  };

    
    
    return( <div>

  
        <div className="back-to-result">
            <Link to="/">Back to results</Link>
        </div>
        {loading ? (
        <div>Loading...</div>
        ) : error ? (
          <div>{error} </div>
        ) : (
        <div className="details">
            <div className="details-image">
                <img src={product.images} alt="Product"></img>
            </div>
            <div className="details-info">
              <ul>
                <li>
                  <h4>{product.name}</h4>
                </li>
                <li>
                  
                    
                      {product.rating+' rating'}</li>
                      <li>
                      {product.numReviews + ' reviews'}
        
                </li>
                <li>
                  Price: <b>${product.price}</b>
                </li>
                <li>
                  Description:
                  <div>{product.description}</div>
                </li>
              </ul>
            </div>
            <div className="details-action">
              <ul>
                <li>Price: $ {product.price}</li>
                <li>
                  Status:{product.cis > 0?"In Stock":"Out Of Stock"}

                </li>
                <li>
                  Qty:<select value={qty}
                    onChange={(e) => {
                      setQty(e.target.value);
                    }}>
                      {[...Array(product.cis).keys()].map((x) => (
                      <option key={x + 1} value={x + 1}>
                        {x + 1}
                      </option>
                    ))}                       
                    </select>
                </li>
                <li>
                {product.cis > 0 && (
                    <button
                      onClick={handleAddToCart}
                      className="button primary"
                    >
                      Add to Cart
                    </button>
                  )}

                 
                </li>
              </ul>
            </div>
          </div>
    
        )}

        </div>);
        }


export default ProductScreen ;